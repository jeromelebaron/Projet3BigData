package fr.s2re.bigdata.backend.mongo.idao;

import java.util.Map;

import fr.s2re.bigdata.entity.Region;

public interface IDaoConnexion {

    /**
     * Pour récupérer les nombre de connexion par {@link Region}.
     * @return une map avec en clé la région en valeur la quantité de connexion.
     */
    public Map<String, Integer> getConnexionQteConnexionByRegion();
}
