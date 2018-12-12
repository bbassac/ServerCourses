package courses.bean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COLLECTION")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Collection {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Liste> listes;

    public Collection() {
        listes = new ArrayList<>(20);
    }


    public List<Liste> getListes() {
        return listes;
    }

    public void setListes(List<Liste> listes) {
        this.listes = listes;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addListe(Liste l) {
        if(listes == null){
            listes= new ArrayList<Liste>();
        }
        listes.add(l);
    }
}
