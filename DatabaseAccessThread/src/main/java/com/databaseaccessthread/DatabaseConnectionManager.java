/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.databaseaccessthread;

/**
 *
 * @author 55649
 */
public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instancia;
    
    private DatabaseAccessThread connection;
    
    private DatabaseConnectionManager (){
        
    }
    
    public static synchronized DatabaseConnectionManager getInstancia(){
        if(instancia == null){
            instancia = new DatabaseConnectionManager();
        }
            return instancia;
    }
    
    public DatabaseAccessThread getDatabaseAccessThread(){
        return connection;
    }
}
