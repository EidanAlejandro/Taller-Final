/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author eidan
 */
public class Biblioteca {
    private ListaSimple libros;
    private ListaDoble autores;
    private ArbolBinario categorias;
    private Queue<Libro> prestamos;

    
    public Biblioteca() {
        this.libros = new ListaSimple();
        this.autores = new ListaDoble();
        this.categorias = new ArbolBinario();
        this.prestamos = new LinkedList<>();
    }

  
    public void agregarLibro(Libro libro) {
        libros.agregar(libro);
    }

    
    public Libro buscarLibro(String titulo) {
        return libros.buscar(titulo);
    }

 
    public void eliminarLibro(String titulo) {
        libros.eliminar(titulo);
    }

    public void mostrarLibros() {
        libros.mostrar();
    }

 
    public void mostrarLibrosDisponibles() {
        libros.mostrarDisponibles();
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Lista de Libros Prestados:");
        for (Libro libro : prestamos) {
            System.out.println(libro);
        }
    }

   
    public void prestarLibro(String titulo) {
        Libro libro = libros.buscar(titulo);
        if (libro != null && !libro.isPrestado()) {
            libro.setPrestado(true);
            prestamos.add(libro);
            System.out.println("Libro prestado: " + libro.getTitulo());
        } else {
            System.out.println("No se pudo prestar el libro.");
        }
    }

    
    public void devolverLibro(String titulo) {
        Libro libro = buscarLibroPrestado(titulo);
        if (libro != null) {
            libro.setPrestado(false);
            prestamos.remove(libro);
            System.out.println("Libro devuelto: " + libro.getTitulo());
        } else {
            System.out.println("No se pudo devolver el libro.");
        }
    }

   
    private Libro buscarLibroPrestado(String titulo) {
        for (Libro libro : prestamos) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

  
    public void agregarAutor(Autor autor) {
        autores.agregar(autor);
    }

   
    public Autor buscarAutor(String nombre) {
        return autores.buscar(nombre);
    }


    public void eliminarAutor(String nombre) {
        autores.eliminar(nombre);
    }


    public void mostrarAutores() {
        autores.mostrar();
    }

   
    public void agregarCategoria(Categoria categoria) {
        categorias.agregar(categoria);
    }

 
    public Categoria buscarCategoria(String nombre) {
        return categorias.buscar(nombre);
    }


    public void eliminarCategoria(String nombre) {
        categorias.eliminar(nombre);
    }

  
    public void mostrarCategorias() {
        categorias.mostrar();
    }

  
    public ArbolBinario getCategorias() {
        return categorias;
    }

    public ListaSimple getLibros() {
        return libros;
    }

    public ListaDoble getAutores() {
        return autores;
    }

    public Queue<Libro> getPrestamos() {
        return prestamos;
    }

}
