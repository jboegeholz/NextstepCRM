package de.creatronix.artist3k.db;

// imports for Log4J
import java.net.URL;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePlugIn implements org.apache.struts.action.PlugIn {
	/**
	 * Member for logging support via Log4J
	 */
	private static Logger logger = Logger.getLogger(HibernatePlugIn.class);

	private String configPath;

	private static org.hibernate.SessionFactory factory;

	public HibernatePlugIn() {

	}

	public HibernatePlugIn(String configPath) {
		this.configPath = configPath;
	}

	public void init(ActionServlet servlet, ModuleConfig ModuleConfig) {

		System.out.println("*************************************");
		System.out.println("**** Initializing HibernatePlugIn   **********");
		
		Configuration configuration = null;
		URL configFileURL = null;
		ServletContext context = null;

		try {
			configFileURL = HibernatePlugIn.class.getResource(configPath);
			System.out.println(configFileURL);
			context = servlet.getServletContext();
			configuration = (new Configuration()).configure(configFileURL);
			factory = configuration.buildSessionFactory();
			// Set the factory into session
			if (factory == null) {
				System.out.println("!!!!!!!!!!!!! FACTORY IS NULL !!!!!!!!!!!!!!!!");
			}
			
		} catch (HibernateException e) {
			System.out.println("Error while initializing hibernate: "
					+ e.getMessage());
		}
		System.out.println("*************************************");

	}

	public void destroy() {
		try {
			factory.close();
		} catch (HibernateException e) {
			System.out.println("Unable to close Hibernate Session Factory: "
					+ e.getMessage());
		}

	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public static SessionFactory  getFactory() {
		return factory;
	}

}
