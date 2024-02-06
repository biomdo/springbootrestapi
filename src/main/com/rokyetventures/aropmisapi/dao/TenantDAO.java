package rokyetventures.aropmisapi.dao;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import rokyetventures.aropmisapi.model.Tenant;

import java.util.List;

public interface TenantDAO {

    //Get all Tenants
    List<Tenant> get();

    //Get tenant by ID Key
    Tenant get(int id);

    //Save tenant
    void save(Tenant tenant);

    //Delete Tenant
    void delete(int id);

}
