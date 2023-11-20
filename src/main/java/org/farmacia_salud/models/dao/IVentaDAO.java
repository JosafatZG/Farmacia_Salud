package org.farmacia_salud.models.dao;

import org.farmacia_salud.models.entity.Venta;
import org.springframework.data.repository.CrudRepository;

public interface IVentaDAO extends CrudRepository<Venta, Long> {
}
