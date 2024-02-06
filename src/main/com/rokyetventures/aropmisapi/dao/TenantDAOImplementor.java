package rokyetventures.aropmisapi.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rokyetventures.aropmisapi.model.Tenant;

import java.util.List;

@Repository
public class TenantDAOImplementor implements TenantDAO {
    //Session Manager
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Tenant> get() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Tenant> query = currentSession.createQuery("from Tenant", Tenant.class);
        return query.getResultList();
    }

    @Override
    public Tenant get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Tenant.class, id);
    }

    @Override
    public void save(Tenant tenant) {
        Session currentSession = entityManager.unwrap(Session.class);
        if(currentSession.get(Tenant.class, tenant.getId())!=null){
            tenant = entityManager.merge(tenant);
        }else{
            currentSession.persist(tenant);
        }
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Tenant tenant = currentSession.get(Tenant.class, id);
        currentSession.remove(tenant);
    }
}
