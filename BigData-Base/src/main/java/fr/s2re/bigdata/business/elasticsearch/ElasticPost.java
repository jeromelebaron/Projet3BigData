/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business.elasticsearch;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.bson.Document;

/**
 * Pour ajouter des éléments en elastic search.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ElasticPost {

    /**
     * POur faire du log.
     */
    private static final Logger LOGGER = Logger.getLogger(ElasticPost.class);
    /**
     * URL du serveur
     */
    private static final String WSURL = "http://127.0.0.1:9200";
    /**
     * 
     */
    private CloseableHttpClient client;

    /**
     * Constructeur.
     */
    public ElasticPost() {
        client = HttpClients.custom().setRetryHandler(new MyRequestRetryHandler()).build();
    }

    /**
     * Pour envoyer un document dans elastic search.
     * @param objetDocument le document à envoyer (pour lequel il faudra retirer l'_id).
     * @param index l'index dans lequel envoyer le document.
     * @param type le type du document.
     * @param id l'identifiant sauvegardé dans elastic search.
     * @throws UnsupportedEncodingException au cas ou.
     */
    public void postToElastic(Document objetDocument, String index, String type, String id)
            throws UnsupportedEncodingException {
        objetDocument.remove("_id");
        final String objetJson = objetDocument.toJson();
        final StringEntity stringEntity = new StringEntity(objetJson);
        stringEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

        final String urlPost = WSURL + "/" + index + "/" + type + "/" + id;
        HttpPost method = new HttpPost(urlPost);
        method.setEntity(stringEntity);

        try {
            CloseableHttpResponse response = client.execute(method);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                LOGGER.error("Method failed: " + response.getStatusLine());
            } else {
                final HttpEntity entity = response.getEntity();
                final String responseBody = EntityUtils.toString(entity);
                LOGGER.info(responseBody);
            }
        } catch (Exception localE) {
            LOGGER.error(localE);
        } finally {
            method.releaseConnection();
        }
    }

}
