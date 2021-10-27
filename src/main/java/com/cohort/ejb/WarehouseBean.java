package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.dao.WarehouseDaoI;
import com.cohort.model.AuditTrail;
import com.cohort.model.Warehouse;
import com.cohort.util.AppException;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class WarehouseBean implements WarehouseBeanI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private WarehouseDaoI warehouseDao;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    /**
     * @see WarehouseBeanI#save(Warehouse)
     */
    public Warehouse save(Warehouse warehouse) throws Exception{
        if (warehouse == null)
            throw new AppException("Invalid warehouse details!!");

        warehouse = warehouseDao.save(warehouse);

        auditTrailEvent.fire(new AuditTrail("Created Warehouse " + warehouse.getName() + " Id: " + warehouse.getId(), new Date()));

        return warehouse;
    }

    /**
     * @see WarehouseBeanI#list(Warehouse, int, int)
     */
    public ModelListWrapper<Warehouse> list(Warehouse filter, int start, int limit){
        return warehouseDao.list(filter, start, limit);
    }

}
