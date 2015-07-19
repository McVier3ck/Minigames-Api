package me.McVier3ck.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.McVier3ck.log.Log;

public class MySQL {


     private String host;
     private int port;
     private String user;
     private String password;
     private String database;
     
     private Connection conn = null;
     
     public MySQL(String host, int port, String user, String password, String database) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
		
		openConnection();
	}
     
     public void openConnection() {
    	 try {
 			Class.forName("com.mysql.jdbc.Driver");
 			Connection connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.password);
 			this.conn = connection;
 		} catch (SQLException e) {
 			Log.Error(e.getMessage());
 		} catch (ClassNotFoundException e) {
 			Log.Error(e.getMessage());
 		}
    	
     }
     
     public Connection getConnection() {
    	 return conn;
     }
     
     public boolean hasConenction() {
    	 try {
			return this.conn != null || this.conn.isValid(1);
		} catch (SQLException e) {
			return false;
		}
     }
     
     public void queryUpdate(String query) {
    	 Connection conn = this.conn;
    	 PreparedStatement st = null;
    	 try {
			st = conn.prepareStatement(query);
			st.execute();
		} catch (SQLException e) {
			Log.Error(e.getMessage());
		} finally {
			this.closeRessources(null, st);
		}
    	 
     }
     
     
     public void closeRessources(ResultSet rs, PreparedStatement st) {
    	 if(rs != null) {
    		 try {
				rs.close();
			} catch (SQLException e) {
				Log.Error(e.getMessage());
			}
    	 }
    	 
    	 if(st != null) {
    		 try {
				st.close();
			} catch (SQLException e) {
				Log.Error(e.getMessage());
			}
    	 }
    	 
     }
     
     public void closeConnection(){
    	 try {
			this.conn.close();
		} catch (SQLException e) {
			Log.Error(e.getMessage());
		}
    	 this.conn = null;
     }
     
     
}
