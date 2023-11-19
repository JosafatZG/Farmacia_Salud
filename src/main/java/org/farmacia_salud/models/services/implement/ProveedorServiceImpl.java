package org.farmacia_salud.models.services.implement;

import org.farmacia_salud.models.dao.IProveedorDAO;
import org.farmacia_salud.models.entity.Proveedor;
import org.farmacia_salud.models.services.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor, IProveedorDAO> implements IProveedorService {
    @Autowired
    public ProveedorServiceImpl(IProveedorDAO repository){
        super(repository);
    }
}
