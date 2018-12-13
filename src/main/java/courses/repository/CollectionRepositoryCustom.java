package courses.repository;

import courses.bean.Collection;
import courses.bean.Item;
import courses.bean.Liste;

/**
 * Created by b.bassac on 24/05/2016.
 */
public interface CollectionRepositoryCustom {

    Collection getCollection();

    void createCollectionIfNotExists();

    Collection ajouterListe(Liste l);

    Collection effacerListe(Long l);

    Liste getListe(Long id);

    Collection update(Liste list);

    Liste addItemToList(Long listId, Item item);

    Liste removeItemToList(Long listId, Item i);
}