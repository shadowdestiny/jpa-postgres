package com.basaki.example.postgres.spring.data.entity;

import com.basaki.example.postgres.spring.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * {@code BookEntity} represents a row in the <code>Books</code> database table.
 * <p/>
 *
 * @author Indra Basak
 * @since 3/8/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria", schema = "example")
public class CategoriaEntity implements Serializable {

    @Id
    @Column(name = "id")
    //@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    //@GeneratedValue(generator = "uuid-gen")
    //@Type(type = "pg-uuid")
    @SequenceGenerator(name="categoria_id_seq",
            sequenceName="example.categoria_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="categoria_id_seq")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}
