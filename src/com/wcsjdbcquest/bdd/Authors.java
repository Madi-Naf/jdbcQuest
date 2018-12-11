package com.wcsjdbcquest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Authors {
	public List<JediMaster> getJediMaster(){
		List<JediMaster> jediMasters = new ArrayList<JediMaster>();
		
		//	Chargement du driver
		//	On utilise un try catch au cas ou ça gérére des exception 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {}
		
		// Connexion à la bade de donnée
		Connection connect = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars", "root", "madi#Naf976");
			
			statement = connect.createStatement(); 
			
			//	Exécution de la requête
			result = statement.executeQuery("SELECT id, name, surname FROM jedi_masters;");
			
			//Recuperation des données
			while (result.next() ){
//				Integer id = result.getInt("id");
				String name = result.getString("name");
				String surname = result.getString("surname");
				
				JediMaster tmpJedi = new JediMaster();
//				tmpJedi.setId(id);
				tmpJedi.setName(name);
				tmpJedi.setSurname(surname);
				
				jediMasters.add(tmpJedi);
			}
			
		}catch (SQLException e) {
		}finally {
			//	Fermeture de la connexion à la base de donnée
			try {
				if(result != null)
					result.close();
				if(statement != null)
					statement.close();
				if(connect != null)
					connect.close();
			}catch(SQLException ignore) {}
			
		}
		
		return jediMasters;
	}
}
