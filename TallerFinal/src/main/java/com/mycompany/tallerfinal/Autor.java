/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;

/**
 *
 * @author eidan
 */
public class Autor {
    private String nombre;
    private Autor siguiente;
    private Autor anterior;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Autor getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Autor siguiente) {
        this.siguiente = siguiente;
    }

    public Autor getAnterior() {
        return anterior;
    }

    public void setAnterior(Autor anterior) {
        this.anterior = anterior;
    }

    public String getAutor() {
        return nombre;
    
    }
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
    

