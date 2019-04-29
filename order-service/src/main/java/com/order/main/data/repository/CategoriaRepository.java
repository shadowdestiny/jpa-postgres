package com.order.main.data.repository;

import com.order.main.data.entity.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * {@code BookRepository} exposes all CRUD operations on a data of type
 * {@code Book}.
 * <p/>
 *
 * @author lmarin
 * @since 27/11/2017
 */
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Integer> {

    List<CategoriaEntity> findByNombreIgnoreCase(String title);

}
