package org.farmacia_salud.models.dao;

import org.farmacia_salud.models.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface IMovimientoDAO extends CrudRepository<Movimiento, Long> {
}
