package org.farmacia_salud.models.services.implement;

import org.farmacia_salud.models.dao.IMovimientoDAO;
import org.farmacia_salud.models.entity.Movimiento;
import org.farmacia_salud.models.services.interfaces.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoServiceImpl extends GenericServiceImpl<Movimiento, IMovimientoDAO> implements IMovimientoService {
    @Autowired
    public MovimientoServiceImpl(IMovimientoDAO repository) {
        super(repository);
    }
}
