package menufact.plats;

public class PlatFactory {
    public static PlatAuMenu getPlatNormal(int code, String description, double prix){
        return new PlatAuMenu(code,description,prix);
    }
    public static PlatEnfant getPlatEnfant(int code, String description, double prix,double proportion){
        return new PlatEnfant(code,description,prix,proportion);
    }
    public static PlatSante getPlatSante(int code, String description, double prix, double kcal, double chol, double gras){
        return new PlatSante(code,description,prix,kcal,chol,gras);
    }
}
