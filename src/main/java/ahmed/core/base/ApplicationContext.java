package ahmed.core.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import ahmed.core.base.Constants;
import fr.edf.com.dacc.HDFSLogger;
//import fr.edf.dco.contacts.bhc.base.HashMultimap;
import fr.edf.dco.connectors.*;
//import ahmed.core.base.ConnectorException;
//import fr.edf.dco.contacts.bhc.base.ConnectorException;
//import fr.edf.dco.contacts.bhc.entities.cartography.Cartography;
//import fr.edf.com.dacc.ConsoleLogger;

/**
 * Singleton Design Pattern Implementation that holds all configurations and
 * properties, along with instances of sources connections
 * 
 * @author ahmed
 */

public class ApplicationContext {

	// ---------------------------------------------------------------------------
	// CONSTRUCTOR
	// ---------------------------------------------------------------------------

	/**
	 * Private singleton constructor
	 */
	private ApplicationContext() {
		loadProperties();

		// if
		// (getProperty(Constants.PROPERTIES_APPLICATION_LOGS).equals(Constants.LOG_CONSOLE))
		// {
		// logger = new ConsoleLogger(this.getClass().getName(),
		// Constants.CONTACT_PROCESS_GOLABAL);
		// } else if
		// (getProperty(Constants.PROPERTIES_APPLICATION_LOGS).equals(Constants.LOG_HDFS))
		// {
		// logger = new HDFSLogger(this.getClass().getName(),
		// Constants.CONTACT_PROCESS_GOLABAL);
		// }
	}

	/**
	 * returns the ApplicationContext singleton unique instance
	 */
	public static ApplicationContext getInstance() {
		if (singleton == null) {
			synchronized (ApplicationContext.class) {
				singleton = new ApplicationContext();
			}
		}

		return singleton;
	}

	public void closeContext() {
		// close HDFS Appenders
		// closeAppenders();

		// closing HBASE connection
		if (hbase != null) {
			try {
				hbase.disconnect();
			} catch (Exception e) {
				// logger.error(Constants.ERROR_HBASE, "could not close hbase
				// connection " + e.getMessage());
			}
		}

		// closing HDFS connection
		if (hdfs != null) {
			try {
				hdfs.disconnect();
			} catch (Exception e) {
				// logger.error(Constants.ERROR_HDFS, "could not close hdfs
				// connection " + e.getMessage());
			}
		}

		// closing SQLServer connection
		if (sql != null) {
			try {
				sql.disconnect();
			} catch (Exception e) {
				// logger.error(Constants.ERROR_SQLSERVER, "could not close
				// SQLServer connection " + e.getMessage());
			}
		}

		// closing KAFKA connection
		if (kafka != null) {
			kafka.disconnect();
		}
	}

	 /**
	   * Access properties file attributes by its name
	   */
	  public String getProperty(String property) {
	    if (properties.containsKey(property)) {
	      return properties.getProperty(property);
	    } else {
//	      logger.error(Constants.ERROR_OTHER, "Property : " + property + " ,is not defined in properties file : " + Constants.PROPERTIES_APPLICATION_FILE_NAME);
	      return null;
	    }
	  }

	  private void loadProperties() {
		    properties = new Properties();
		    FileInputStream inputStream;

		    try {
		      inputStream = new FileInputStream(Constants.PROPERTIES_APPLICATION_FILE_NAME);
		      properties.load(inputStream);
		      inputStream.close();
		    } catch (IOException e) {
//		      logger.error(Constants.ERROR_OTHER, "Unable to locate properties file : " + Constants.PROPERTIES_APPLICATION_FILE_NAME);
		    }
		  }
	
	 /**
	   * Return unique instance of HbaseConnector
	   */
	  public HbaseConnector getHbase() {
	    if (hbase == null) {
	      hbase = new HbaseConnector(getProperty(Constants.PROPERTIES_KERBEROS_USER), getProperty(Constants.PROPERTIES_KERBEROS_KEYTAB), true);
	      try {
	        hbase.connect();
	      } catch (Exception e) {
//	        logger.error(Constants.ERROR_HBASE, "Unable to connect to hbase : " + e.getMessage());
	      }
	    }

	    return hbase;
	  }

	  /**
	   * Return unique instance of HDFSConnector
	   */
	  public HdfsConnector getHdfs() {
	    if (hdfs == null) {
	      hdfs = new HdfsConnector(getProperty(Constants.PROPERTIES_KERBEROS_USER), getProperty(Constants.PROPERTIES_KERBEROS_KEYTAB), true);

	      try {
	        hdfs.connect();
	      } catch (Exception e) {
//	        logger.error(Constants.ERROR_HDFS, "Unable to connect to hdfs : " + e.getMessage());
	      }
	    }

	    return hdfs;
	  }

	  /**
	   * Return unique instance of KafkaConnector
	   */
	  public KafkaConnector getKafka(String topic) {
	    if (kafka == null) {
	      kafka = new KafkaConnector(getProperty(Constants.PROPERTIES_KAFKA_ZOOKEEPER_QUORUM), getProperty(Constants.PROPERTIES_KAFKA_BROKERS_LIST), UUID.randomUUID().toString());
	      kafka.setTopic(topic);
	      kafka.connect();
	    }

	    return kafka;
	  }


	private static volatile ApplicationContext singleton = null;
	private static Properties properties;
	@SuppressWarnings("unused")
	private static HDFSLogger logger;
	private static HbaseConnector hbase = null;
	private static HdfsConnector hdfs = null;
	private static KafkaConnector kafka = null;
	private static SqlServerConnector sql = null;
	// private static HashMultimap<String, Cartography> cartgraphy = null;
	// private static HashMap<String, Put> contactsPuts = null;
	// private static HashMap<String, BufferedWriter> hdfsFileAppenders = null;
	// private static HashMap<String, HDFSLogger> loggers = null;
	public void flushContacts(boolean b) {
		
	}

}
