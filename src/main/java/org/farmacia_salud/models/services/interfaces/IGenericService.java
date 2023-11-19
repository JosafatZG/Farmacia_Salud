package org.farmacia_salud.models.services.interfaces;

import java.util.Optional;

public interface IGenericService<E> {
    Optional<E> findById(Long id);

    E save(E e);

    Iterable<E> findAll();

    void deleteById(Long id);
}
