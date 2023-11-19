package org.farmacia_salud.models.dao;

import org.farmacia_salud.models.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorDAO extends CrudRepository<Proveedor, Long> {
}
