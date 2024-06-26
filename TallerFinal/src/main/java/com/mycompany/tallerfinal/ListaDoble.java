/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;

/**
 *
 * @author eidan
 */
public class ListaDoble {
    private Autor cabeza;
    private Autor cola;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }
    

    public void agregar(Autor autor) {
        if (cabeza == null) {
            cabeza = cola = autor;
        } else {
            cola.setSiguiente(autor);
            autor.setAnterior(cola);
            cola = autor;
        }
    }

    public Autor buscar(String nombre) {
        Autor actual = cabeza;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void eliminar(String nombre) {
        Autor actual = cabeza;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    cabeza = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    cola = actual.getAnterior();
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }
    public void mostrar() {
        Autor actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getAutor());
            actual = actual.getSiguiente();
        }
    }
}
