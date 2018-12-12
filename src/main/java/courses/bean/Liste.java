package courses.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LISTE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Liste {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM",nullable = false)
    @NotEmpty
    private String nom;

    @Column(name="template",nullable = false)
    private boolean template;



    @ManyToOne
    private Collection collection;

    public Liste(RestListe l) {
        this.id = l.getId();
        this.nom = l.getNom();
        this.template = l.isTemplate();
    }




    // Mus have no-argument constructor
    public Liste() {

    }

    public Liste(String nom) {
        this.nom = nom;

    }


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


    public boolean isTemplate() {
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
