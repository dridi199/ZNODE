package fr.edf.dco.connectors;

import org.apache.hadoop.conf.Configuration;


public class HbaseConnector {

	// ---------------------------------------------------------------------------
	// CONSTRUCTOR
	// ---------------------------------------------------------------------------
	
	public HbaseConnector(String property, String property2, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	public void connect() {
		// TODO Auto-generated method stub
		
	}

	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	//------------------------------------------------------------------
	  // ACCESSORS
	  //------------------------------------------------------------------

	  /**
	   * Set hbase table name
	   */
	  public void setTable(String table) {
	    this.htable = table;
	  }

	  /**
	   * Set hbase column family
	   */
	  public void setColumnFamily(String family) {
	    this.columnFamily = family;
	  }

	  /**
	   * Set hbase row id
	   */
	  public void setRow(String row) {
	    this.row = row;
	  }

//	  /**
//	   * Returns HbaseConnection
//	   * @return
//	   */
//	  public Connection getConnection() {
//	    return this.connection;
//	  }

	  //------------------------------------------------------------------
	  // DATA_MEMBERS
	  //------------------------------------------------------------------

//	  private Connection            connection;
	  private String                htable;
	  private String                columnFamily;
	  private String                row;
	}

