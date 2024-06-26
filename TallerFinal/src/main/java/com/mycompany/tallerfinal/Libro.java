/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;

/**
 *
 * @author eidan
 */
public class Libro {
    private String titulo;
    private Autor autor;
    private Categoria categoria;
    private boolean prestado;

    public Libro(String titulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.prestado = false;
    }


    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isPrestado() {
        return prestado;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }


    public void prestar() {
        if (!prestado) {
            this.prestado = true;
            System.out.println("El libro ha sido prestado.");
        } else {
            System.out.println("El libro ya está prestado.");
        }
    }


    public void devolver() {
        if (prestado) {
            this.prestado = false;
            System.out.println("El libro ha sido devuelto.");
        } else {
            System.out.println("El libro no está prestado.");
        }
    }


    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.getNombre() +
                ", categoria=" + categoria.getNombre() +
                ", prestado=" + prestado +
                '}';
    }
}
    
