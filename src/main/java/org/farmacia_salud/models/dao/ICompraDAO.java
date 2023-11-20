package org.farmacia_salud.models.dao;

import org.farmacia_salud.models.entity.Compra;
import org.springframework.data.repository.CrudRepository;

public interface ICompraDAO extends CrudRepository<Compra, Long> {
}
