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
package org.androidsoft.opendata.remarkabletrees.model;

import android.util.Log;
import org.androidsoft.poi.model.AbstractPOI;

/**
 * RemarkableTree
 * @author Pierre LEVY
 */
public class RemarkableTree extends AbstractPOI
{

    private Integer _arrondissement;
    private String _genre;
    private String _espece;
    private String _famille;
    private Integer _annee;
    private Integer _hauteur;
    private Integer _circonference;
    private String _adresse;
    private String _nomCommun;
    private String _variete;
    private String _espaceVert;
    
    public RemarkableTree(String[] record)
    {
        try
        {
            setId(Integer.parseInt(record[0]));
            _arrondissement = getInt(record[1]);
            _genre = record[2];
            _espece = record[3];
            _famille = record[4];
            _annee = getInt(record[5]);
            _hauteur = getInt(record[6]);
            _circonference = getInt(record[7]);
            _adresse = record[8];
            _nomCommun = record[9];
            _variete = record[10];
            _espaceVert = record[11];
            setLatitude( getDouble(record[13]));
            setLongitude( getDouble(record[12]));
            Log.d("opendata.poi", "Reading successfully record #" + getId() );
        }
        catch (NumberFormatException e)
        {
            System.out.print(e.getMessage());
            Log.e("opendata.poi", "Error reading : " + _nomCommun );
        }
        
    }
    
    /**
     * @return the _arrondissement
     */
    public int getArrondissement()
    {
        return _arrondissement;
    }

    /**
     * @param arrondissement the _arrondissement to set
     */
    public void setArrondissement(int arrondissement)
    {
        _arrondissement = arrondissement;
    }

    /**
     * @return the _genre
     */
    public String getGenre()
    {
        return _genre;
    }

    /**
     * @param genre the _genre to set
     */
    public void setGenre(String genre)
    {
        _genre = genre;
    }

    /**
     * @return the _espece
     */
    public String getEspece()
    {
        return _espece;
    }

    /**
     * @param espece the _espece to set
     */
    public void setEspece(String espece)
    {
        _espece = espece;
    }

    /**
     * @return the _famille
     */
    public String getFamille()
    {
        return _famille;
    }

    /**
     * @param famille the _famille to set
     */
    public void setFamille(String famille)
    {
        _famille = famille;
    }

    /**
     * @return the _annee
     */
    public Integer getAnnee()
    {
        return _annee;
    }

    /**
     * @param annee the _annee to set
     */
    public void setAnnee(Integer annee)
    {
        _annee = annee;
    }

    /**
     * @return the _hauteur
     */
    public Integer getHauteur()
    {
        return _hauteur;
    }

    /**
     * @param hauteur the _hauteur to set
     */
    public void setHauteur(Integer hauteur)
    {
        _hauteur = hauteur;
    }

    /**
     * @return the _circonference
     */
    public Integer getCirconference()
    {
        return _circonference;
    }

    /**
     * @param circonference the _circonference to set
     */
    public void setCirconference(Integer circonference)
    {
        _circonference = circonference;
    }

    /**
     * @return the _adresse
     */
    public String getAdresse()
    {
        return _adresse;
    }

    /**
     * @param adresse the _adresse to set
     */
    public void setAdresse(String adresse)
    {
        _adresse = adresse;
    }

    /**
     * @return the _nomCommun
     */
    public String getNomCommun()
    {
        return _nomCommun;
    }

    /**
     * @param nomCommun the _nomCommun to set
     */
    public void setNomCommun(String nomCommun)
    {
        _nomCommun = nomCommun;
    }

    /**
     * @return the _variete
     */
    public String getVariete()
    {
        return _variete;
    }

    /**
     * @param variete the _variete to set
     */
    public void setVariete(String variete)
    {
        _variete = variete;
    }
    
    public String getTitle()
    {
        return _nomCommun;
    }
    
    public String getDescription()
    {
        return _espaceVert;
    }

    /**
     * @return the espace Vert
     */
    public String getEspaceVert()
    {
        return _espaceVert;
    }

    /**
     * @param espaceVert the espace Vert to set
     */
    public void setEspaceVert(String espaceVert)
    {
        _espaceVert = espaceVert;
    }
}
