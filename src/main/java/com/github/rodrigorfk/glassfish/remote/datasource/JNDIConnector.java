/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.rodrigorfk.glassfish.remote.datasource;

import java.util.Hashtable;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author rodrigokuntzer
 */
public class JNDIConnector {

    private final InitialContext ic;
    
    public JNDIConnector(Map<String,String> params) throws NamingException {
        ic = new InitialContext(new Hashtable<>(params));
    }
    
    public DataSource lookupDataSource(String jndi) throws NamingException{
        System.out.println("will lookup JNDI with the following parameters "+ic.getEnvironment());
        return (DataSource) ic.lookup(jndi);
    }

    public void close() throws NamingException {
        ic.close();
    }
    
}
