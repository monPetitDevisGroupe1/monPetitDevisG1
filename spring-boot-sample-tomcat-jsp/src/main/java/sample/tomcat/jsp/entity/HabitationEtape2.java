package sample.tomcat.jsp.entity;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "habitation_etape2")
public class HabitationEtape2 {
    private Integer id;
    private int nbrPiece;
    private int etage;
    private int nbrSalleBain;
    private byte garage;
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
    @Column(name = "nbr_piece", nullable = false)
    public int getNbrPiece() {
        return nbrPiece;
    }

    public void setNbrPiece(int nbrPiece) {
        this.nbrPiece = nbrPiece;
    }

    @Basic
    @Column(name = "etage", nullable = false)
    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    @Basic
    @Column(name = "nbr_salle_bain", nullable = false)
    public int getNbrSalleBain() {
        return nbrSalleBain;
    }

    public void setNbrSalleBain(int nbrSalleBain) {
        this.nbrSalleBain = nbrSalleBain;
    }

    @Basic
    @Column(name = "garage", nullable = false)
    public byte getGarage() {
        return garage;
    }

    public void setGarage(byte garage) {
        this.garage = garage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HabitationEtape2 that = (HabitationEtape2) o;

        if (id != that.id) return false;
        if (nbrPiece != that.nbrPiece) return false;
        if (etage != that.etage) return false;
        if (nbrSalleBain != that.nbrSalleBain) return false;
        if (garage != that.garage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nbrPiece;
        result = 31 * result + etage;
        result = 31 * result + nbrSalleBain;
        result = 31 * result + (int) garage;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_devis",  nullable = false)
    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }
}
