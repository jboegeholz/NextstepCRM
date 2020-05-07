package de.creatronix.artist3k.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import de.creatronix.artist3k.db.HibernateUtil;

public class StageActTest {

	@Test
	public void testStoreStageAct() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		StageAct stageAct = new StageAct();
		stageAct.setName("damn hot shit");
		

		session.saveOrUpdate(stageAct);
		transaction.commit();
		session.close();

	}

	@Test
	public void testLoadStageAct() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		StageAct stageAct = (StageAct) session.get(StageAct.class, "damn hot shit");

		assertEquals(stageAct.getName(), "damn hot shit");
		transaction.commit();
		session.close();
	}
	@Test
	public void testGetAllStageActs() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Collection<StageAct> stageActs;
		stageActs = session.createQuery("select h from StageAct as h").list();
		transaction.commit();
		session.close();

		assertEquals(((StageAct)stageActs.toArray()[0]).getName(), "damn hot shit");
	}
}
