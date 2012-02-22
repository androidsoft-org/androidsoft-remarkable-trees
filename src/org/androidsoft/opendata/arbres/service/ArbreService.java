/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.service;

import org.androidsoft.opendata.arbres.model.Arbre;
import org.androidsoft.poi.service.POIService;

/**
 *
 * @author pierre
 */
public class ArbreService extends POIService<Arbre>
{
    private static final String CSV_FILE = "arbres.csv";

    @Override
    public String getAssetFile()
    {
        return CSV_FILE;
    }

    @Override
    public Arbre newInstance(String[] record)
    {
        return new Arbre( record );
    }
    
}
