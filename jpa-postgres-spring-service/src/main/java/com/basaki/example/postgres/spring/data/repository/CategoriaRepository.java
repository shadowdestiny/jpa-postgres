package com.basaki.example.postgres.spring.data.repository;

import com.basaki.example.postgres.spring.data.entity.CategoriaEntity;
import com.basaki.example.postgres.spring.data.entity.CategoriaEntity;
import com.basaki.example.postgres.spring.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

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
