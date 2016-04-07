package sample.tomcat.jsp.entity;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
@Table(name = "habitation_etape3")
public class HabitationEtape3 {
    private Integer id;
    private int surfaceTerrain;
    private int surfaceTerrasse;
    private int typeChauffage;
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
    @Column(name = "surface_terrain", nullable = false)
    public int getSurfaceTerrain() {
        return surfaceTerrain;
    }

    public void setSurfaceTerrain(int surfaceTerrain) {
        this.surfaceTerrain = surfaceTerrain;
    }

    @Basic
    @Column(name = "surface_terrasse", nullable = false)
    public int getSurfaceTerrasse() {
        return surfaceTerrasse;
    }

    public void setSurfaceTerrasse(int surfaceTerrasse) {
        this.surfaceTerrasse = surfaceTerrasse;
    }

    @Basic
    @Column(name = "type_chauffage", nullable = false)
    public int getTypeChauffage() {
        return typeChauffage;
    }

    public void setTypeChauffage(int typeChauffage) {
        this.typeChauffage = typeChauffage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HabitationEtape3 that = (HabitationEtape3) o;

        if (id != that.id) return false;
        if (surfaceTerrain != that.surfaceTerrain) return false;
        if (surfaceTerrasse != that.surfaceTerrasse) return false;
        if (typeChauffage != that.typeChauffage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + surfaceTerrain;
        result = 31 * result + surfaceTerrasse;
        result = 31 * result + typeChauffage;
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
