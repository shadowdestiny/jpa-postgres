package com.basaki.example.postgres.spring.controller;

import com.basaki.example.postgres.spring.model.Categoria;
import com.basaki.example.postgres.spring.model.Categoria;
import com.basaki.example.postgres.spring.model.CategoriaRequest;
import com.basaki.example.postgres.spring.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@code CategoriaController} is the spring REST controller for categoria API. Exposes
 * all CRUD operations on categoria.
 * <p/>
 *
 * @author lmarin
 * @since 27/11/2017
 */
@RestController
@Slf4j
@Api(value = "Categoria API",
        description = "Categoria API",
        produces = "application/json", tags = {"API"})
public class CategoriaController {

    public static final String BOOK_URL = "/categoria";

    public static final String BOOK_BY_ID_URL = BOOK_URL + "/{id}";


    @Autowired
    private CategoriaService service;

    @ApiOperation(
            value = "Creates an categoria.",
            notes = "Requires categoria nombre categoria.",
            response = Categoria.class)
    @ApiResponses({
            @ApiResponse(code = 201, response = Override.class,
                    message = "Override override created successfully")})
    @RequestMapping(method = RequestMethod.POST, value = BOOK_URL,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody CategoriaRequest request) {
        return service.create(request);
    }

    @ApiOperation(
            value = "Retrieves a categoria by ID.",
            notes = "Requires a categoria identifier",
            response = Categoria.class)
    @RequestMapping(method = RequestMethod.GET, value = BOOK_BY_ID_URL,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Categoria read(@PathVariable("id") Integer id) {
        return service.read(id);
    }

    @ApiOperation(
            value = "Retrieves all categorias associated with a title, author, category or combination of them.",
            response = Categoria.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, value = BOOK_URL,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Categoria> read(
            @RequestParam(value = "nombre", required = false) String nombre
    ) {
        return service.read(nombre);
    }

    @ApiOperation(value = "Updates a categoria.", response = Categoria.class)
    @ApiResponses({
            @ApiResponse(code = 201, response = Categoria.class,
                    message = "Updated a categoria created successfully")})
    @RequestMapping(method = RequestMethod.PUT, value = BOOK_BY_ID_URL,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@PathVariable("id") Integer id,
            @RequestBody CategoriaRequest request) {
        return service.update(id, request);
    }

    @ApiOperation(value = "Deletes a categoria by ID.")
    @RequestMapping(method = RequestMethod.DELETE, value = BOOK_BY_ID_URL)
    @ResponseBody
    public void deleteById(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Deletes all categorias.")
    @RequestMapping(method = RequestMethod.DELETE, value = BOOK_URL)
    @ResponseBody
    public void deleteAll() {
        service.deleteAll();
    }
}
