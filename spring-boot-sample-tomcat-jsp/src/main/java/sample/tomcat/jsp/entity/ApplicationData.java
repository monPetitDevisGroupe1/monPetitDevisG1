package sample.tomcat.jsp.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Pierre on 10/05/2016.
 */
@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationData {

    private Integer id;
    private String pseudo;
    private Integer idDevis;
    private String nomDevis;
    private Devis devis;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }
    
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Integer getIdDevis() {
        return idDevis;
    }
    public Devis getDevis() {
        return devis;
    }
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    public void setIdDevis(Integer idDevis) {
        this.idDevis = idDevis;
    }

    public String getNomDevis() {
        return nomDevis;
    }
    public void setNomDevis(String nomDevis) {
        this.nomDevis = nomDevis;
    }

}
