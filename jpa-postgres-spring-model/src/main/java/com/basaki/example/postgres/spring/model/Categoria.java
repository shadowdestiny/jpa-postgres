package com.basaki.example.postgres.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * {@code Categoria} represents a book entity.
 * <p/>
 *
 * @author lmarin Basak
 * @since 27/11/2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
