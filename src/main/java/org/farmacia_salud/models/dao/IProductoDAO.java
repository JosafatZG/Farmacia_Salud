package org.farmacia_salud.models.dao;

import org.farmacia_salud.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDAO extends CrudRepository<Producto, Long> {
}
