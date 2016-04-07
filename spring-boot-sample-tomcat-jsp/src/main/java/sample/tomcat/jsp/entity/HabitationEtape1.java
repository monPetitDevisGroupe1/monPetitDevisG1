package sample.tomcat.jsp.entity;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "habitation_etape1")
public class HabitationEtape1 {
    private Integer id;
    private String typeHabitation;
    private int surface;
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
    @Column(name = "type_habitation", nullable = false, length = 25)
    public String getTypeHabitation() {
        return typeHabitation;
    }

    public void setTypeHabitation(String typeHabitation) {
        this.typeHabitation = typeHabitation;
    }

    @Basic
    @Column(name = "surface", nullable = false)
    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HabitationEtape1 that = (HabitationEtape1) o;

        if (id != that.id) return false;
        if (surface != that.surface) return false;
        if (typeHabitation != null ? !typeHabitation.equals(that.typeHabitation) : that.typeHabitation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeHabitation != null ? typeHabitation.hashCode() : 0);
        result = 31 * result + surface;
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
