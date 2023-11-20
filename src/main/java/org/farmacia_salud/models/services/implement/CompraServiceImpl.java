package org.farmacia_salud.models.services.implement;

import org.farmacia_salud.models.dao.ICompraDAO;
import org.farmacia_salud.models.entity.Compra;
import org.farmacia_salud.models.services.interfaces.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, ICompraDAO> implements ICompraService {
    @Autowired
    public CompraServiceImpl(ICompraDAO repository) {
        super(repository);
    }
}
