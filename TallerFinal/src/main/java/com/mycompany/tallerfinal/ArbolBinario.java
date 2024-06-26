/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;

/**
 *
 * @author eidan
 */
public class ArbolBinario {
    private Categoria raiz;


    public void agregar(Categoria categoria) {
        raiz = agregarRecursivo(raiz, categoria);
    }

    private Categoria agregarRecursivo(Categoria actual, Categoria categoria) {
        if (actual == null) {
            return categoria;
        }
        if (categoria.getNombre().compareTo(actual.getNombre()) < 0) {
            actual.setIzquierda(agregarRecursivo(actual.getIzquierda(), categoria));
        } else if (categoria.getNombre().compareTo(actual.getNombre()) > 0) {
            actual.setDerecha(agregarRecursivo(actual.getDerecha(), categoria));
        }
        return actual;
    }

    public Categoria buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    private Categoria buscarRecursivo(Categoria actual, String nombre) {
        if (actual == null || actual.getNombre().equals(nombre)) {
            return actual;
        }
        if (nombre.compareTo(actual.getNombre()) < 0) {
            return buscarRecursivo(actual.getIzquierda(), nombre);
        } else {
            return buscarRecursivo(actual.getDerecha(), nombre);
        }
    }

    public void eliminar(String nombre) {
        raiz = eliminarRecursivo(raiz, nombre);
    }

    private Categoria eliminarRecursivo(Categoria actual, String nombre) {
        if (actual == null) {
            return null;
        }
        if (nombre.equals(actual.getNombre())) {

            if (actual.getIzquierda() == null) {
                return actual.getDerecha();
            }
            if (actual.getDerecha() == null) {
                return actual.getIzquierda();
            }

            String menorValor = encontrarMenorValor(actual.getDerecha());
            actual.setNombre(menorValor);
            actual.setDerecha(eliminarRecursivo(actual.getDerecha(), menorValor));
            return actual;
        }
        if (nombre.compareTo(actual.getNombre()) < 0) {
            actual.setIzquierda(eliminarRecursivo(actual.getIzquierda(), nombre));
            return actual;
        }
        actual.setDerecha(eliminarRecursivo(actual.getDerecha(), nombre));
        return actual;
    }

    private String encontrarMenorValor(Categoria raiz) {
        return raiz.getIzquierda() == null ? raiz.getNombre() : encontrarMenorValor(raiz.getIzquierda());
    }
    public void mostrar() {
        mostrarOrden(raiz);
    }

    private void mostrarOrden(Categoria raiz) {
        if (raiz != null) {
            mostrarOrden(raiz.getIzquierda());
            System.out.println(raiz.getNombre());
            mostrarOrden(raiz.getDerecha());
        }
    }
    
}
