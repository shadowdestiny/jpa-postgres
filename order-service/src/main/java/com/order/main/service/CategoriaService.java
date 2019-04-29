package com.order.main.service;

import com.order.main.data.entity.CategoriaEntity;
import com.order.main.data.repository.CategoriaRepository;
import com.order.main.error.DataNotFoundException;
import com.order.main.error.InvalidSearchException;
import com.order.model.*;
import com.order.model.Categoria;
import com.order.model.CategoriaRequest;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code CategoriaService} service provides data access service for {@code Categoria}.
 * <p/>
 *
 * @author lmarin
 * @sice 27/11/17
 */
@Service
@Slf4j
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    private Mapper mapper;

    @Autowired
    public CategoriaService(CategoriaRepository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Categoria create(CategoriaRequest request) {
        validate(request);

        CategoriaEntity entity = mapper.map(request, CategoriaEntity.class);
        entity = repo.save(entity);
        Categoria categoria = mapper.map(entity, Categoria.class);

        return categoria;
    }

    public Categoria read(Integer id) {
        CategoriaEntity entity = repo.findOne(id);
        return map(entity);
    }

    public List<Categoria> read(String nombre) {
        if (nombre != null) {
            return map(repo.findByNombreIgnoreCase(nombre));
        } else {
            throw new InvalidSearchException(
                    "Specify at least one search critera!");
        }
    }

    @Transactional
    public Categoria update(Integer id, CategoriaRequest request) {
        CategoriaEntity entity = repo.findOne(id);

        if (entity == null) {
            throw new DataNotFoundException(
                    "Categoria with id " + id + " not found!");
        }

        validate(request);
        mapper.map(request, entity);
        entity = repo.save(entity);

        Categoria categoria = mapper.map(entity, Categoria.class);

        return categoria;
    }

    public void delete(Integer id) {
        repo.delete(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    private List<Categoria> map(List<CategoriaEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            throw new DataNotFoundException(
                    "No Categorias found with the search criteria!");
        }

        return entities.stream().map(
                r -> mapper.map(r, Categoria.class)).collect(
                Collectors.toList());
    }

    private void validate(CategoriaRequest request) {
        Assert.notNull(request.getNombre(), "Title can't be null!");
    }

    private Categoria map(CategoriaEntity entity) {
        if (entity == null) {
            throw new InvalidSearchException("Categoria not found!");
        }

        return mapper.map(entity, Categoria.class);
    }
}
