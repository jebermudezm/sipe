package jebm.sipe;

/**
 * Created by joaquin.bermudez on 2015-02-26.
 */
public class EntiTipoDocu {
    private String codtipodocu;
    private String nomtipodocu;

    public String getCodtipodocu(){
        return codtipodocu;
    }
    public void setcodtipodocu(String pcodtipodocu){
        codtipodocu = pcodtipodocu;
    }
    public String getNomtipodocu(){
        return codtipodocu;
    }
    public void setNomtipodocu(String pnomtipodocu){
        nomtipodocu = pnomtipodocu;
    }
    public String toString(){
        return nomtipodocu;
    }
}
