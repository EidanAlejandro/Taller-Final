/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;

/**
 *
 * @author eidan
 */
public class ListaSimple {
    private NodoLibro cabeza;

    private class NodoLibro {
        Libro libro;
        NodoLibro siguiente;

        NodoLibro(Libro libro) {
            this.libro = libro;
            this.siguiente = null;
        }
    }


    public void agregar(Libro libro) {
        NodoLibro nuevoNodo = new NodoLibro(libro);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLibro actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public Libro buscar(String titulo) {
        NodoLibro actual = cabeza;
        while (actual != null) {
            if (actual.libro.getTitulo().equals(titulo)) {
                return actual.libro;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void eliminar(String titulo) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.libro.getTitulo().equals(titulo)) {
            cabeza = cabeza.siguiente;
            return;
        }
        NodoLibro actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.libro.getTitulo().equals(titulo)) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }
    
    public void mostrar() {
        NodoLibro actual = cabeza;
        while (actual != null) {
            System.out.println(actual.libro);
            actual = actual.siguiente;
        }
    }
    
    public void mostrarDisponibles() {
        NodoLibro actual = cabeza;
        while (actual != null) {
            if (!actual.libro.isPrestado()) {
                System.out.println(actual.libro);
            }
            actual = actual.siguiente;
        }
    }
}
