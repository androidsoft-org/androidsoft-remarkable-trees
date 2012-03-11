/* Copyright (c) 2012 Pierre LEVY androidsoft.org
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.androidsoft.opendata.arbres.service;

import android.content.Context;
import java.util.List;
import org.androidsoft.opendata.arbres.model.Arbre;
import org.androidsoft.poi.service.POIService;

/**
 * Arbre Service
 * @author Pierre LEVY
 */
public class ArbreService extends POIService<Arbre>
{
    
    private static ArbreService mSingleton = new ArbreService();
    
    
    private static final String CSV_FILE = "arbres.csv";

    public static ArbreService instance()
    {
        return mSingleton;
    }
    
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
    
    public Arbre getTree( Context context , int id )
    {
        List<Arbre> list = getPOIs( context );
        for( Arbre arbre : list )
        {
            if( arbre.getId() == id )
            {
                return arbre;
            }
        }
        return null;
    }
    
}
