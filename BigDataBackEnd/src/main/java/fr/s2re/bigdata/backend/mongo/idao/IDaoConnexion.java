package fr.s2re.bigdata.backend.mongo.idao;

import java.util.List;

import fr.s2re.bigdata.backend.wrapper.ConnexionRegionWrapper;
import fr.s2re.bigdata.entity.Region;

public interface IDaoConnexion {

    /**
     * Pour récupérer les nombre de connexion par {@link Region}.
     * @return une liste de {@link ConnexionRegionWrapper}.
     */
    public List<ConnexionRegionWrapper> getConnexionQteConnexionByRegion();
}
