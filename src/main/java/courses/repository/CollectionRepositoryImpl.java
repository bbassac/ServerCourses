package courses.repository;

import courses.bean.Collection;
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


}
