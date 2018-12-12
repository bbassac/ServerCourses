package courses.repository;

import courses.LogUtils;
import courses.bean.Collection;
import courses.bean.Liste;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by b.bassac on 24/05/2016.
 */
@Repository
@Transactional
public class CollectionRepositoryImpl implements CollectionRepositoryCustom {


    @PersistenceContext
     EntityManager entityManager;

    public Collection getCollection(){
        Query query = entityManager.createQuery("SELECT c FROM Collection c order by c.id ASC");
        List<Collection> res = query.getResultList();
        return res.isEmpty() ? null : res.get(0);
    }

    @Override
    public void createCollectionIfNotExists() {
        if (getCollection()==null){
            createEmptyCollection();
        }
    }

    @Override
    public Collection ajouterListe(Liste l) {
        LogUtils.warn("Adding liste "+ l.getNom());
        Collection c =getCollection();
        c.addListe(l);
        l.setCollection(c);
        entityManager.persist(l);
        return getCollection();
    }

    @Override
    public Collection effacerListe(Long id) {
        Liste dbListe = getListe(id);
        if(dbListe !=null){
            LogUtils.warn("Deleting liste id "+ id);
            dbListe.getCollection().getListes().remove(dbListe);
            entityManager.remove(dbListe);
        }else{
            LogUtils.warn("Liste id "+ id + " Not found");
        }
        return getCollection();
    }

    @Override
    public Liste getListe(Long id) {
        LogUtils.warn("Looking for liste id "+ id );
        Liste dbListe = entityManager.find(Liste.class,id);
        return dbListe;
    }

    private void createEmptyCollection() {
        LogUtils.warn("Creating empty collection");
        Collection c = new Collection();
        entityManager.persist(c);
    }


}
