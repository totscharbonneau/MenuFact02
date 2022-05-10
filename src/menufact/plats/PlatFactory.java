package menufact.plats;

public class PlatFactory {
    /**
     *
     * @param code du plat
     * @param description du plat
     * @param prix unitaire du plat
     * @return un plat normal
     */
    public static PlatAuMenu getPlatNormal(int code, String description, double prix){
        return new PlatAuMenu(code,description,prix);
    }

    /**
     *
     * @param code du plat
     * @param description du plat
     * @param prix unitaire du plat
     * @param proportion proportion d'un plat normal
     * @return
     */
    public static PlatEnfant getPlatEnfant(int code, String description, double prix,double proportion){
        return new PlatEnfant(code,description,prix,proportion);
    }

    /**
     *
     * @param code du plat
     * @param description du plat
     * @param prix unitaire du plat
     * @param kcal contenu dans le plat
     * @param chol contenu dans le plat
     * @param gras contenu dans le plat
     * @return
     */
    public static PlatSante getPlatSante(int code, String description, double prix, double kcal, double chol, double gras){
        return new PlatSante(code,description,prix,kcal,chol,gras);
    }
}
