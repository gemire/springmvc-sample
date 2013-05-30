/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.MapConfiguration;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.configuration.ThirdPartyJaxRsPackage;

/**
 *
 * @author dhenton
 */
 

public class Neo4jServerConfig implements Configurator {

    private Configuration config;

    public Neo4jServerConfig(Map<String, String> config) {
        this.config = new MapConfiguration(config);
    }

    @Override
    public Configuration configuration() {
        return config; 
    }

    @Override
    public Map<String, String> getDatabaseTuningProperties() {
        return null;
    }

    @Override
    public Set<ThirdPartyJaxRsPackage> getThirdpartyJaxRsClasses() {
        return new HashSet<ThirdPartyJaxRsPackage>();
    }
}