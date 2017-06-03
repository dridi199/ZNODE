package fr.edf.dco.connectors;


import fr.edf.dco.common.connector.base.Constants;

/**
 * SQLServer database access connector
 * 
 * @author fahd-externe.essid@edf.fr
 */
public class SqlServerConnector  {

  //-----------------------------------------------------------------
  // CONSTRUCTOR
  //-----------------------------------------------------------------

  /**
   * Constructs an instance of SQLServercontainer
   * @param host        : sql server host adress
   * @param port        : sql server port
   * @param user        : database user name
   * @param password    : database user password
   * @param database    : database schema name
   */
  public SqlServerConnector(String host,
      int port,
      String user,
      String password,
      String database) 
  {
//    super(host, port, user, password, database);
  }

  /**
   * Constructs an instance of SQLServercontainer using default port
   * @param host        : sql server host adress
   * @param user        : database user name
   * @param password    : database user password
   * @param database    : database schema name
   */
  public SqlServerConnector(String host,
      String instance,
      String user,
      String password,
      String database) 
  {
//    super(host, Constants.SQL_SERVER_DEFAULT_PORT, user, password, database);

//    driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    connectionUrl = "jdbc:sqlserver://" + this.host + ";instanceName=" + instance + ";DatabaseName=" + this.database;
  }

public void disconnect() {
	// TODO Auto-generated method stub
	
}
}
