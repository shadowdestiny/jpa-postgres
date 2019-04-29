package com.order.model;

import lombok.Data;

/**
 * {@code BookRequest} represents a request to create or update a book entity.
 * <p/>
 *
 * @author Indra Basak
 * @since 3/8/17
 */
@Data
public class CategoriaRequest {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
