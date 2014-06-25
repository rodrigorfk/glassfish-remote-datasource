/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.rodrigorfk.glassfish.remote.datasource;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author rodrigokuntzer
 */
public class App {
    
    public static void main(String[] args) throws NamingException, SQLException {
        if(args.length == 0){
            System.out.println("USAGE: provide the JNDI name of the datasource");
            return ;
        }
        
        JNDIConnector connector = new JNDIConnector();
        
        Map<String,String> params = new HashMap<>();
        params.put("java.naming.factory.initial", Constants.JAVA_NAMING_FACTORY_INITIAL);
        params.put("org.omg.CORBA.ORBInitialHost", Constants.ORG_OMG_CORBA_ORBINITIALHOST);
        params.put("org.omg.CORBA.ORBInitialPort", Constants.ORG_OMG_CORBA_ORBINITIALPORT);
        
        String sql = "select 1 from dual";
        String jndi = args[0];
        DataSource dataSource = connector.lookupDataSource(jndi, params);
        
        try (Connection con = dataSource.getConnection()) {
            try(Statement stmt = con.createStatement()){
                try(ResultSet rs = stmt.executeQuery(sql)){
                    while(rs.next()) {
                        System.out.println("Query '" + sql + "' returned " + rs.getString(1));
                    }
                }
            }
        }
    }
}
