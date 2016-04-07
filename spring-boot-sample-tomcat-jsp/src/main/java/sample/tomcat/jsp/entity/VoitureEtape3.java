package sample.tomcat.jsp.entity;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "voiture_etape3")
public class VoitureEtape3 {
    private int id;
    private byte dorsGarage;
    private String adresseGarage;
    private String conducteurPrincipal;
    private String conducteurSecondaire;
    private Devis devis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dors_garage", nullable = false)
    public byte getDorsGarage() {
        return dorsGarage;
    }

    public void setDorsGarage(byte dorsGarage) {
        this.dorsGarage = dorsGarage;
    }

    @Basic
    @Column(name = "adresse_garage", nullable = false, length = 50)
    public String getAdresseGarage() {
        return adresseGarage;
    }

    public void setAdresseGarage(String adresseGarage) {
        this.adresseGarage = adresseGarage;
    }

    @Basic
    @Column(name = "conducteur_principal", nullable = false, length = 50)
    public String getConducteurPrincipal() {
        return conducteurPrincipal;
    }

    public void setConducteurPrincipal(String conducteurPrincipal) {
        this.conducteurPrincipal = conducteurPrincipal;
    }

    @Basic
    @Column(name = "conducteur_secondaire", nullable = false, length = 50)
    public String getConducteurSecondaire() {
        return conducteurSecondaire;
    }

    public void setConducteurSecondaire(String conducteurSecondaire) {
        this.conducteurSecondaire = conducteurSecondaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoitureEtape3 that = (VoitureEtape3) o;

        if (id != that.id) return false;
        if (dorsGarage != that.dorsGarage) return false;
        if (adresseGarage != null ? !adresseGarage.equals(that.adresseGarage) : that.adresseGarage != null)
            return false;
        if (conducteurPrincipal != null ? !conducteurPrincipal.equals(that.conducteurPrincipal) : that.conducteurPrincipal != null)
            return false;
        if (conducteurSecondaire != null ? !conducteurSecondaire.equals(that.conducteurSecondaire) : that.conducteurSecondaire != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) dorsGarage;
        result = 31 * result + (adresseGarage != null ? adresseGarage.hashCode() : 0);
        result = 31 * result + (conducteurPrincipal != null ? conducteurPrincipal.hashCode() : 0);
        result = 31 * result + (conducteurSecondaire != null ? conducteurSecondaire.hashCode() : 0);
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
