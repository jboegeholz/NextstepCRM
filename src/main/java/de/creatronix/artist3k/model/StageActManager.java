package de.creatronix.artist3k.model;

import java.util.Collection;
import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.creatronix.artist3k.db.HibernatePlugIn;
import de.creatronix.artist3k.exception.StageActAlreadyExistsException;

public class StageActManager {
	private Collection<StageAct> stageActs = null;
	private SessionFactory factory;
	public StageActManager() {

		
	}

	public Collection<StageAct> getAllStageActs() {
		Session hbnSession = null;
		hbnSession = factory.openSession();
		hbnSession.beginTransaction();
		stageActs = hbnSession.createQuery("select h from StageAct as h").list();
		hbnSession.getTransaction().commit();
		return stageActs;
	}

	public void saveToDB(StageAct stageAct) throws StageActAlreadyExistsException {
		if (loadStageActByName(stageAct.getName()) != null) {
			throw new StageActAlreadyExistsException();
		}
		Session hbnSession = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			hbnSession.save(stageAct);
			hbnSession.flush();
			hbnSession.getTransaction().commit();
		} catch (HibernateException e) {
			hbnSession.getTransaction().rollback();
		} finally {
			hbnSession.close();
		}

	}
	public StageAct loadStageActByName(String name) {
		Session hbnSession = null;
		StageAct stageAct = null;
		try {
			hbnSession = factory.openSession();
			hbnSession.beginTransaction();
			stageAct = (StageAct) hbnSession.get(StageAct.class, name);
			hbnSession.getTransaction().commit();
			if (stageAct == null) {
				System.out.println("StageAct " + name + " not found!!");
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			if (hbnSession != null) {
				hbnSession.close();
			}
		}
		return stageAct;
	}
	public void testStoreStageAct()
	{
		factory = HibernatePlugIn.getFactory();
		
		StageAct stageact2= new StageAct();
		stageact2.setName("Excess Pressure");

		StageAct stageact3 = new StageAct();
		stageact3.setName("Alex Amsterdam - Solo");
		StageAct stageact4 = new StageAct();
		stageact4.setName("Alex Amsterdam + Piano");
		StageAct stageact5 = new StageAct();
		stageact5.setName("Alex Amsterdam + Band");
		try {
			saveToDB(stageact2);
			saveToDB(stageact3);
			saveToDB(stageact4);
			saveToDB(stageact5);
		} catch (StageActAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getNumberOfStageActs() {
		return getAllStageActs().size();
	}

}
