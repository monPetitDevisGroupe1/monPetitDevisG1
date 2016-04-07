package sample.tomcat.jsp.entity;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "voiture_etape1")
public class VoitureEtape1 {
    private Integer id;
    private String marque;
    private String modele;
    private String carburant;
    private int chevauxFisc;
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
    @Column(name = "marque", nullable = false, length = 25)
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "modele", nullable = false, length = 25)
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "carburant", nullable = false, length = 10)
    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    @Basic
    @Column(name = "chevaux_fisc", nullable = false)
    public int getChevauxFisc() {
        return chevauxFisc;
    }

    public void setChevauxFisc(int chevauxFisc) {
        this.chevauxFisc = chevauxFisc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoitureEtape1 that = (VoitureEtape1) o;

        if (id != that.id) return false;
        if (chevauxFisc != that.chevauxFisc) return false;
        if (marque != null ? !marque.equals(that.marque) : that.marque != null) return false;
        if (modele != null ? !modele.equals(that.modele) : that.modele != null) return false;
        if (carburant != null ? !carburant.equals(that.carburant) : that.carburant != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (modele != null ? modele.hashCode() : 0);
        result = 31 * result + (carburant != null ? carburant.hashCode() : 0);
        result = 31 * result + chevauxFisc;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_devis", referencedColumnName = "id_devis", nullable = false)
    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }
}
