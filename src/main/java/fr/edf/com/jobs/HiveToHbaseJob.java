package fr.edf.com.jobs;


import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;


import ahmed.core.base.ApplicationContext;
import ahmed.core.base.Constants;
import ahmed.core.base.ContactFactory;
import ahmed.*;


public class HiveToHbaseJob {

  public static void main(String[] args) {

    final String table = "args[0]";
//    final String separator = args[1];
    final String distributionColumn = "args[1]";

    // spark application settings
    SparkConf sparkConfiguration = new SparkConf().setAppName(Constants.CONTACT_SPARK_APP_HIVE_HBASE).setMaster("local");
    JavaSparkContext sparkContext = new JavaSparkContext(sparkConfiguration);
    HiveContext hiveContext = new HiveContext(sparkContext);

    // Retrieving Hive table
    JavaRDD<Row> tableContentRDD = hiveContext.sql("select * from " + table + " DISTRIBUTE BY " + distributionColumn).toJavaRDD();

    // hbase puts
    tableContentRDD.foreachPartition(new VoidFunction<Iterator<Row>>() {

      private static final long serialVersionUID = -5844753255324191699L;

//      @Override
      public void call(Iterator<Row> rows) throws Exception {
        ApplicationContext context = ApplicationContext.getInstance();
        ContactFactory factory = new ContactFactory();

//        String line = null;
//        AbstractContactRecord record = null;
//        while (rows.hasNext()) {
//          try {
//            line = rows.next().mkString(separator);
//
//            record = factory.createRecord(line.substring(0, line.indexOf(separator)));
//            record.parse(line.substring(line.indexOf(separator) + 1, line.length()));
//            record.storeToHbase();
//          } catch (Exception e) {
//            // log later ..
//          }
//        }

        context.flushContacts(true);
      }
    });
    
    ApplicationContext context = ApplicationContext.getInstance();
    System.out.println(context.getProperty("env"));
    System.out.println(context.getProperty("contactsTable"));
      
  }
}
