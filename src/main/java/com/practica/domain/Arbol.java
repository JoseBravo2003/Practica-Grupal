
package com.practica.domain;

import jakarta.persistence.*;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;



@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;
    private String nombre;
    private String altura;
    private String tipo_fruto;
    private String rutaImagen;
    private boolean activo;

    public Arbol() {
    }

    public Arbol(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
    
}
