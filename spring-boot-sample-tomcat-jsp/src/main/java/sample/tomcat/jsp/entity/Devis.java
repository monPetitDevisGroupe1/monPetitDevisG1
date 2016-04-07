package sample.tomcat.jsp.entity;




import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
public class Devis {
    private int idDevis;
    private String nom;
    private String typeDevis;
    private int etape;
    private HabitationEtape1 habitationEtape1;
    private HabitationEtape2 habitationEtape2;
    private HabitationEtape3 habitationEtape3;
    private HabitationEtape4 habitationEtape4;
    private VoitureEtape1 voitureEtape1;
    private VoitureEtape2 voitureEtape2;
    private VoitureEtape3 voitureEtape3;
    private VoitureEtape4 voitureEtape4;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devis", nullable = false)
    public int getIdDevis() {
        return idDevis;
    }

    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 25)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "type_devis", nullable = false, length = 20)
    public String getTypeDevis() {
        return typeDevis;
    }

    public void setTypeDevis(String typeDevis) {
        this.typeDevis = typeDevis;
    }

    @Basic
    @Column(name = "etape", nullable = false)
    public int getEtape() {
        return etape;
    }

    public void setEtape(int etape) {
        this.etape = etape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Devis devis = (Devis) o;

        if (idDevis != devis.idDevis) return false;
        if (etape != devis.etape) return false;
        if (nom != null ? !nom.equals(devis.nom) : devis.nom != null) return false;
        if (typeDevis != null ? !typeDevis.equals(devis.typeDevis) : devis.typeDevis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDevis;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (typeDevis != null ? typeDevis.hashCode() : 0);
        result = 31 * result + etape;
        return result;
    }

    @OneToOne(mappedBy = "devis")
    public HabitationEtape1 getHabitationEtape1() {
        return habitationEtape1;
    }

    public void setHabitationEtape1(HabitationEtape1 habitationEtape1) {
        this.habitationEtape1 = habitationEtape1;
    }

    @OneToOne(mappedBy = "devis")
    public HabitationEtape2 getHabitationEtape2() {
        return habitationEtape2;
    }

    public void setHabitationEtape2(HabitationEtape2 habitationEtape2) {
        this.habitationEtape2 = habitationEtape2;
    }

    @OneToOne(mappedBy = "devis")
    public HabitationEtape3 getHabitationEtape3() {
        return habitationEtape3;
    }

    public void setHabitationEtape3(HabitationEtape3 habitationEtape3) {
        this.habitationEtape3 = habitationEtape3;
    }

    @OneToOne(mappedBy = "devis")
    public HabitationEtape4 getHabitationEtape4() {
        return habitationEtape4;
    }

    public void setHabitationEtape4(HabitationEtape4 habitationEtape4) {
        this.habitationEtape4 = habitationEtape4;
    }

    @OneToOne(mappedBy = "devis")
    public VoitureEtape1 getVoitureEtape1() {
        return voitureEtape1;
    }

    public void setVoitureEtape1(VoitureEtape1 voitureEtape1) {
        this.voitureEtape1 = voitureEtape1;
    }

    @OneToOne(mappedBy = "devis")
    public VoitureEtape2 getVoitureEtape2() {
        return voitureEtape2;
    }

    public void setVoitureEtape2(VoitureEtape2 voitureEtape2) {
        this.voitureEtape2 = voitureEtape2;
    }

    @OneToOne(mappedBy = "devis")
    public VoitureEtape3 getVoitureEtape3() {
        return voitureEtape3;
    }

    public void setVoitureEtape3(VoitureEtape3 voitureEtape3) {
        this.voitureEtape3 = voitureEtape3;
    }

    @OneToOne(mappedBy = "devis")
    public VoitureEtape4 getVoitureEtape4() {
        return voitureEtape4;
    }

    public void setVoitureEtape4(VoitureEtape4 voitureEtape4) {
        this.voitureEtape4 = voitureEtape4;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
