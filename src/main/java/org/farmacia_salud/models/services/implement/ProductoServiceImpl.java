package org.farmacia_salud.models.services.implement;

import org.farmacia_salud.models.dao.IProductoDAO;
import org.farmacia_salud.models.entity.Producto;
import org.farmacia_salud.models.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, IProductoDAO> implements IProductoService {
    @Autowired
    public ProductoServiceImpl(IProductoDAO repository) {
        super(repository);
    }
}
