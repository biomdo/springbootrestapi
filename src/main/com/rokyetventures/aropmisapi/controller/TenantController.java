package rokyetventures.aropmisapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rokyetventures.aropmisapi.model.Tenant;
import rokyetventures.aropmisapi.service.TenantService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/tenant")
    public List<Tenant> get() {
        return tenantService.get();
    }

    @GetMapping("/tenant/{id}")
    public Tenant get(@PathVariable int id) {
        Tenant tenant = tenantService.get(id);
        if (tenant == null)
            throw new RuntimeException("Tenant with id " + id + " not found.");
        return tenant;
    }

    @PutMapping("/tenant")
    public Tenant update(@RequestBody Tenant tenant) {
        tenantService.save(tenant);
        return tenant;
    }

    @PostMapping("/tenant")
    public Tenant save(@RequestBody Tenant tenant) {
        tenantService.save(tenant);
        return tenant;
    }

    @DeleteMapping("/tenant/{id}")
    public String delete(@PathVariable int id) {
        Tenant targetTenant = tenantService.get(id);
        if (targetTenant == null)
            throw new RuntimeException("Tenant with id " + id + " not found.");
        tenantService.delete(id);
        return "Tenant record deleted.";
    }
}
