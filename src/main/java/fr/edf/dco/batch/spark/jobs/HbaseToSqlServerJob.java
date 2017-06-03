//package fr.edf.dco.batch.spark.jobs;
//
//import java.util.Properties;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.sql.SQLContext;
//
//import ahmed.core.base.ApplicationContext;
//import ahmed.core.base.Constants;
//import fr.edf.dco.connectors.HbaseConnector;
//import fr.edf.dco.contacts.bhc.batch.spark.jobs.ConnectorException;
//import fr.edf.dco.contacts.bhc.batch.spark.jobs.SqlServerConnector;
//
//public class HbaseToSqlServerJob {
//    // getting environment context
//    ApplicationContext context = ApplicationContext.getInstance();
//    HbaseConnector hbase = context.getHbase();
//
//    // configuring HBASE
//    Configuration hbaseConfiguration = hbase.getConfiguration();
////    hbaseConfiguration.set(TableInputFormat.SCAN_MAXVERSIONS, "100");
////    hbaseConfiguration.setInt("timeout", 120000);
//
//    // spark application settings
//    SparkConf sparkConfiguration = new SparkConf().setAppName(Constants.CONTACT_SPARK_APP_HBASE_HIVE);
//    JavaSparkContext sparkContext = new JavaSparkContext(sparkConfiguration);
//    SQLContext sqlContext = new SQLContext(sparkContext);
//    
//    
//    // MS SQL Server settings
//    Properties sqlServerOptions = new Properties();
//    SqlServerConnector sqlServer = null;
//
//    //TODO : delete this case once SQLServer Prod is ready !!!
//    if (context.getProperty(Constants.PROPERTIES_APPLICATION_ENV_NAME).equals("Prod")) {
//      sqlServer = new SqlServerConnector("10.122.3.254", "PMDBI", "cs_bhc", "_6w[q9KL6,7D", "Contacts_Sortants_Reporting");
//
//      try {
//        sqlServer.connect();
//      } catch (ConnectorException e) {
//        e.printStackTrace();
//      }
//    } else {
//      sqlServer = ApplicationContext.getInstance().getSqlServer();
//    }
//
//    sqlServerOptions.put("driver", sqlServer.getDriverClassName());
//    sqlServerOptions.put("url", sqlServer.getConnectionUrl());
//    sqlServerOptions.put("user", sqlServer.getUser());
//    sqlServerOptions.put("password", sqlServer.getUserPwd());
//    
//    
//    
//    
//    
//    
//    
//}
