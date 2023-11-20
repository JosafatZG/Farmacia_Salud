package org.farmacia_salud.models.services.implement;

import org.farmacia_salud.models.dao.IVentaDAO;
import org.farmacia_salud.models.entity.Venta;
import org.farmacia_salud.models.services.interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl extends GenericServiceImpl<Venta, IVentaDAO> implements IVentaService {
    @Autowired
    public VentaServiceImpl(IVentaDAO repository) {
        super(repository);
    }
}
