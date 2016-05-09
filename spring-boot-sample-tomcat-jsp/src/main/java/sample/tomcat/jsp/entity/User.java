package sample.tomcat.jsp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Entity
public class User {
    private Integer id;
    private String nom;
    private String prenom;
    private Date datePermis;
    private String typeUser;
    private List<Devis> devis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "prenom", nullable = false, length = 25)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
    @Column(name = "type_user", nullable = false, length = 20)
    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.getId()) return false;
        if (nom != null ? !nom.equals(user.nom) : user.nom != null) return false;
        if (prenom != null ? !prenom.equals(user.prenom) : user.prenom != null) return false;
        if (datePermis != null ? !datePermis.equals(user.datePermis) : user.datePermis != null) return false;
        if (typeUser != null ? !typeUser.equals(user.typeUser) : user.typeUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (datePermis != null ? datePermis.hashCode() : 0);
        result = 31 * result + (typeUser != null ? typeUser.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "user")
    public List<Devis> getDevis() {
        return devis;
    }

    public void setDevis(List<Devis> devis) {
        this.devis = devis;
    }
}
