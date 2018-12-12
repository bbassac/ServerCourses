package courses.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import courses.controller.RestItem;


import javax.persistence.*;

/**
 * Created by b.bassac on 12/01/2015.
 */
@Entity
@Table(name = "ITEM")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Item implements Comparable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOM",nullable = false)
    private String nom;
    @Column(name = "QUANTITE")
    private String quantite;

    @ManyToOne
    @JsonBackReference
    private Liste liste;

    public Item(RestItem item) {
        this.id = item.getId();
        this.nom = item.getNom();
        this.quantite= item.getQuantite();
        this.done = item.isDone();
    }

    @Column(name="DONE",nullable = false)
    private boolean done = false;


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

    public Liste getListe() {
        return liste;
    }

    public void setListe(Liste liste) {
        this.liste = liste;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
