package rokyetventures.aropmisapi.service;

import rokyetventures.aropmisapi.model.Tenant;

import java.util.List;
public interface TenantService {
    //Get all Tenants
    List<Tenant> get();

    //Get tenant by ID Key
    Tenant get(int id);

    //Save tenant
    void save(Tenant tenant);

    //Delete Tenant
    void delete(int id);
}
