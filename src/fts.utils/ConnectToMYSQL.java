package fts.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.jndi.cosnaming.CNCtx;
import java.sql.*;  

/**
 *
 * @author student
 */
public class ConnectToMYSQL {
    Connection con=null;

    public ResultSet getResultSet(String qry){
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();  
                rs=stmt.executeQuery(qry); 
            }
        }catch(Exception ex){
        }  
        return rs;
    }
    public String getSingleStringVal(String qry){
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();  
                rs=stmt.executeQuery(qry); 
                return rs.getString(1);
            }
        }catch(Exception ex){
        }  
        return null;
    }  
    public int getSingleIntVal(String qry){
         ResultSet rs=null;
        try{
            if(!con.isClosed()){
                Statement stmt=con.createStatement();  
                rs=stmt.executeQuery(qry); 
                return rs.getInt(1);
            }
        }catch(Exception ex){
        }  
        return 0;
    }      
    public int InsertQuery(String qry){
        try{
            if(!con.isClosed()){               
               Statement statement = con.createStatement();
               statement.executeUpdate(qry);
               return statement.getUpdateCount();
            }
        }catch(Exception ex){
            System.err.println("Query:"+qry+"");
            System.err.println(ex.getMessage()+"");
            return -1;
        }
        return 0;
    }
    public boolean  isValidText(String s){
        
        if(s.trim().length()>0){
            return true;
        }
        return false;
    }
    public ConnectToMYSQL() {
        try{  
           // Class.forName("com.mysql.jdbc.Driver");  
           // Connection con=DriverManager.getConnection("jdbc:mysql://108.167.136.53:3306/mrdevuj6_miniproject","mrdevuj6_miniusr","r572@cseorc");    
            //Statement stmt=con.createStatement();  
            //con.close();  
           
           String url = "jdbc:mysql://localhost:3306/fts_db";
           Class.forName ("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection (url,"root","");
           System.out.println ("Database connection established");
        }catch(Exception e){ 
            System.out.println(e);}  
        }  

}
