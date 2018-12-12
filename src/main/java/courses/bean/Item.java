package courses.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;

/**
 * Created by b.bassac on 12/01/2015.
 */
@Entity
@Table(name = "BD")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Item implements Comparable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOM")
    private String nom;
    @Column(name = "QUANTITE")
    private String quantite;


    @ManyToOne
    @JsonBackReference
    private Liste liste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Liste getListe() {
        return liste;
    }

    public void setListe(Liste liste) {
        this.liste = liste;
    }

    public Item() {
    }

    public Item(Long id, String nom, String quantite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;

    }


    @Override
    public int compareTo(Object o) {
        return this.getId().compareTo(((Item) o).getId());
    }
}
