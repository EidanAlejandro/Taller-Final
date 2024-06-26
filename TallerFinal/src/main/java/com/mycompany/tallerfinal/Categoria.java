/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;

/**
 *
 * @author eidan
 */
public class Categoria {
    private String nombre;
    private Categoria izquierda;
    private Categoria derecha;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }



    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Categoria izquierda) {
        this.izquierda = izquierda;
    }

    public Categoria getDerecha() {
        return derecha;
    }

    public void setDerecha(Categoria derecha) {
        this.derecha = derecha;
    }


    public void agregarCategoria(Categoria nuevaCategoria) {
        if (nuevaCategoria == null) {
            throw new IllegalArgumentException("La categoría a agregar no puede ser nula.");
        }
        
        if (nuevaCategoria.getNombre().compareTo(this.nombre) < 0) {
            if (izquierda == null) {
                izquierda = nuevaCategoria;
            } else {
                izquierda.agregarCategoria(nuevaCategoria);
            }
        } else if (nuevaCategoria.getNombre().compareTo(this.nombre) > 0) {
            if (derecha == null) {
                derecha = nuevaCategoria;
            } else {
                derecha.agregarCategoria(nuevaCategoria);
            }
        }
        
    }


    public Categoria buscarCategoria(String nombreCategoria) {
        if (nombreCategoria.compareTo(this.nombre) == 0) {
            return this;
        } else if (nombreCategoria.compareTo(this.nombre) < 0 && izquierda != null) {
            return izquierda.buscarCategoria(nombreCategoria);
        } else if (nombreCategoria.compareTo(this.nombre) > 0 && derecha != null) {
            return derecha.buscarCategoria(nombreCategoria);
        }
        return null; // No se encontró la categoría
    }


    public Categoria eliminarCategoria(String nombreCategoria) {
        return eliminarRecursivo(null, nombreCategoria);
    }

    private Categoria eliminarRecursivo(Categoria parent, String nombreCategoria) {
        if (nombreCategoria.compareTo(this.nombre) < 0 && izquierda != null) {
            return izquierda.eliminarRecursivo(this, nombreCategoria);
        } else if (nombreCategoria.compareTo(this.nombre) > 0 && derecha != null) {
            return derecha.eliminarRecursivo(this, nombreCategoria);
        } else {
            // Encontramos el nodo a eliminar
            if (izquierda != null && derecha != null) {
                // Caso 3: nodo con dos hijos
                Categoria sucesor = derecha.encontrarMenor();
                this.nombre = sucesor.getNombre();
                derecha = derecha.eliminarCategoria(sucesor.getNombre());
                return this;
            } else if (parent == null) {
                // Caso 1: nodo raíz con un solo hijo o sin hijos
                return (izquierda != null) ? izquierda : derecha;
            } else {
                // Caso 2: nodo interno con un solo hijo o sin hijos
                return (this == parent.izquierda) ? izquierda : derecha;
            }
        }
    }

    private Categoria encontrarMenor() {
        return (izquierda == null) ? this : izquierda.encontrarMenor();
    }


    public void mostrarCategorias() {
        if (izquierda != null) {
            izquierda.mostrarCategorias();
        }
        System.out.println(nombre);
        if (derecha != null) {
            derecha.mostrarCategorias();
        }
    }
    
}
