package me.McVier3ck.stats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.McVier3ck.log.Log;
import me.McVier3ck.mysql.MySQL;

import org.bukkit.entity.Player;


public class Stats {
    
	private MySQL mysql = null; 
    private Connection conn = null;
    private String tablename;
     
	public Stats(MySQL mysql, String tablename) {
		this.mysql = mysql;
		conn = mysql.getConnection();
		this.tablename = tablename;
		
	}
	
	public void setStat(Player player, String stat, String statvalue) {
		mysql.queryUpdate("UPDATE " + tablename + " SET " + stat + "='" + statvalue + "' WHERE player='" + player.getUniqueId().toString() + "'");
		
	}
	

	public String getStat(Player player, String stat) {
		ResultSet rs = null;
		PreparedStatement st = null;
		String statvalue = null;
		try {
			st = conn.prepareStatement("SELECT * FROM " + tablename + " WHERE player=?");
			st.setString(1, player.getUniqueId().toString());
			rs = st.executeQuery();
			rs.last();
			if(rs.getRow() != 0) {
				rs.first();
				statvalue = rs.getString(stat);
			}
		} catch (SQLException e) {
			Log.Error(e.getMessage());
		} finally {
			mysql.closeRessources(rs, st);
		}
		
		
		return statvalue;
	}
	
}
