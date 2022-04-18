package com.xanmalodon.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.xanmalodon.web.model.Alien;

public class AlienDao {

	public Alien getAlien(int aid) {
		Alien a = new Alien();
		
//		a.setAid(101);
//		a.setAname("Louis");
//		a.setTech("Java");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/louis?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "root");
// pr eviter le : The server time zone value 'Paris, Madrid (heure d??t?)' is unrecognized or represents more than one time zone. 
// You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
			
			Statement  st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from alien where aid=" + aid);
			if(rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));
			}
			
		}catch(Exception e){
			 System.out.println(e);
		}finally {
		}
		return a;
	}
}
