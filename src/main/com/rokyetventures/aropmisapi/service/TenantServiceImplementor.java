package rokyetventures.aropmisapi.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rokyetventures.aropmisapi.dao.TenantDAO;
import rokyetventures.aropmisapi.model.Tenant;

import java.util.List;
@Service
public class TenantServiceImplementor implements TenantService{
    @Autowired
    private TenantDAO tenantDAO;

    @Transactional
    @Override
    public List<Tenant> get() {
       return tenantDAO.get();
    }

    @Transactional
    @Override
    public Tenant get(int id) {
        return tenantDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Tenant tenant) {
        tenantDAO.save(tenant);
    }

    @Transactional
    @Override
    public void delete(int id) {
        tenantDAO.delete(id);
    }
}
