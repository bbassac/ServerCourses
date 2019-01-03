package courses.repository;

import courses.LogUtils;
import courses.bean.Collection;
import courses.bean.Item;
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
        entityManager.persist(c);
        return getCollection();
    }

    @Override
    public Collection effacerListe(Long id) {
        Liste dbListe = getListe(id);
        if(dbListe !=null){
            LogUtils.warn("Deleting liste id "+ id);
            dbListe.getCollection().getListes().remove(dbListe);
            entityManager.remove(dbListe);
            entityManager.merge(dbListe.getCollection());
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


    public Item getItem(Long id) {
        LogUtils.warn("Looking for liste id "+ id );
        Item dbItem = entityManager.find(Item.class,id);
        return dbItem;
    }

    @Override
    public Collection update(Liste list) {
        if(list.getId()!= null){
            LogUtils.warn("Updating list id "+ list.getId() );
            Liste dbList = getListe(list.getId());
            dbList.setNom(list.getNom());
            dbList.setTemplate(list.isTemplate());
            entityManager.merge(dbList);
        }
        return getCollection();
    }

    @Override
    public Liste addItemToList(Long listId, Item item) {
        LogUtils.warn("Adding item to  liste "+ listId);
        Liste l =getListe(listId);
        l.addItem(item);
        item.setListe(l);
        entityManager.persist(l);
        return l;
    }

    @Override
    public Liste removeItemToList(Long listId, Item i) {

        Item dbItem = getItem(i.getId());
        if(dbItem !=null){
            LogUtils.warn("Deleting item id "+ i.getId());
            dbItem.getListe().getItems().remove(dbItem);
            entityManager.remove(dbItem);
            entityManager.merge(dbItem.getListe());
        }else{
            LogUtils.warn("Item  "+ i.getId() + " from list " + listId + " Not found");
        }
        return getListe(listId);
    }

    @Override
    public Liste updateItem(Long listId, Item i) {

        Item dbItem = getItem(i.getId());
        dbItem.setNom(i.getNom());
        dbItem.setQuantite(i.getQuantite());
        dbItem.setDone(i.isDone());

        entityManager.merge(dbItem);
        return dbItem.getListe();
    }


    private void createEmptyCollection() {
        LogUtils.warn("Creating empty collection");
        Collection c = new Collection();
        entityManager.persist(c);
    }


}
