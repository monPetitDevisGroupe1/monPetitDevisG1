package sample.tomcat.jsp.entity;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "voiture_etape4")
public class VoitureEtape4 {
    private Integer id;
    private int prix;
    private String formule;
    private Devis devis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prix", nullable = false)
    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "formule", nullable = false, length = 25)
    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoitureEtape4 that = (VoitureEtape4) o;

        if (id != that.id) return false;
        if (prix != that.prix) return false;
        if (formule != null ? !formule.equals(that.formule) : that.formule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + prix;
        result = 31 * result + (formule != null ? formule.hashCode() : 0);
        return result;
    }

    @OneToOne(optional = true, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_devis", referencedColumnName = "id_devis", nullable = false)
    public Devis getDevis() {
        return devis;
    }
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
}
