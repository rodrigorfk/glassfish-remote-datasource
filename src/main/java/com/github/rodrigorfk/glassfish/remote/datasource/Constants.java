/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.rodrigorfk.glassfish.remote.datasource;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author rodrigokuntzer
 */
public class Constants {

    private Constants() {
    }
    
    public static final String JAVA_NAMING_FACTORY_INITIAL = "com.sun.enterprise.naming.SerialInitContextFactory";
    public static final String ORG_OMG_CORBA_ORBINITIALHOST = StringUtils.defaultIfEmpty(System.getProperty("JNDI_HOST"),"localhost");
    public static final String ORG_OMG_CORBA_ORBINITIALPORT = StringUtils.defaultIfEmpty(System.getProperty("JNDI_PORT"),"3700");
}
