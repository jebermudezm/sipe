package jebm.sipe;

/**
 * Created by joaquin.bermudez on 2015-02-26.
 */
public class EntiCiudad {
    private String codciudad;
    private String nomciudad;

    public String getCodciuad(){
        return codciudad;
    }
    public void setCodciudad(String pcodciudad){
        codciudad = pcodciudad;
    }
    public String getNomciudad(){
        return nomciudad;
    }
    public void setNomciudad(String pnomciudad){
        nomciudad = pnomciudad;
    }
    public String toString(){
        return nomciudad;
    }
}
