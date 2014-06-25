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
    
    public DataSource lookupDataSource(String jndi, Map<String,String> params) throws NamingException{
        InitialContext ic = new InitialContext(new Hashtable<>(params));
        return (DataSource) ic.lookup(jndi);
    }
    
}
