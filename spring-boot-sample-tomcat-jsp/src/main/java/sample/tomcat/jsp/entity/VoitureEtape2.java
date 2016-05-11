package sample.tomcat.jsp.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "voiture_etape2")
public class VoitureEtape2 {
    private Integer id;
    private Date datePermis;
    private int nbrAccident;
    private int bonusMalus;
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
    @Column(name = "date_permis", nullable = false)
    public Date getDatePermis() {
        return datePermis;
    }

    public void setDatePermis(Date datePermis) {
        this.datePermis = datePermis;
    }

    @Basic
    @Column(name = "nbr_accident", nullable = false)
    public int getNbrAccident() {
        return nbrAccident;
    }

    public void setNbrAccident(int nbrAccident) {
        this.nbrAccident = nbrAccident;
    }

    @Basic
    @Column(name = "bonus_malus", nullable = false)
    public int getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(int bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoitureEtape2 that = (VoitureEtape2) o;

        if (id != that.id) return false;
        if (nbrAccident != that.nbrAccident) return false;
        if (bonusMalus != that.bonusMalus) return false;
        if (datePermis != null ? !datePermis.equals(that.datePermis) : that.datePermis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datePermis != null ? datePermis.hashCode() : 0);
        result = 31 * result + nbrAccident;
        result = 31 * result + bonusMalus;
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
