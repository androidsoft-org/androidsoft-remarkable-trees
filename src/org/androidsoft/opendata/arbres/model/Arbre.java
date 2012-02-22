/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.model;

import android.util.Log;
import org.androidsoft.poi.model.AbstractPOI;

/**
 *
 * @author pierre
 */
public class Arbre extends AbstractPOI
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
    
    public Arbre(String[] record)
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
    
    public String getDesciption()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Année de plantation : " ).append( _annee ).append("\n");
        sb.append("Hauteur : " ).append( _hauteur ).append("\n");
        sb.append("Circonférence : " ).append( _circonference ).append("\n");
        sb.append("Lieu : " ).append( _espaceVert ).append("\n");
        return sb.toString();
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
