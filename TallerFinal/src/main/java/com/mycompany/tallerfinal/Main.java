/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerfinal;
import java.util.Scanner;
/**
 *
 * @author eidan
 */
public class Main {
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Gestion de Categorias");
            System.out.println("2. Gestion de Autores");
            System.out.println("3. Gestion de Libros");
            System.out.println("4. Prestamo de Libros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); 
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    menuCategorias(scanner);
                    break;
                case 2:
                    menuAutores(scanner);
                    break;
                case 3:
                    menuLibros(scanner);
                    break;
                case 4:
                    menuPrestamos(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void menuCategorias(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Gestion de Categorias:");
            System.out.println("1. Crear Categoria");
            System.out.println("2. Editar Categoria");
            System.out.println("3. Eliminar Categoria");
            System.out.println("4. Mostrar lista completa de Categorias");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Descartar la entrada invalida
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la nueva categoria: ");
                    String nombreCategoria = scanner.nextLine();
                    Categoria categoria = new Categoria(nombreCategoria);
                    biblioteca.agregarCategoria(categoria);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la categoria a editar: ");
                    String nombreCategoriaEditar = scanner.nextLine();
                    Categoria categoriaEditar = biblioteca.buscarCategoria(nombreCategoriaEditar);
                    if (categoriaEditar != null) {
                        System.out.print("Ingrese el nuevo nombre de la categoria: ");
                        String nuevoNombreCategoria = scanner.nextLine();
                        categoriaEditar.setNombre(nuevoNombreCategoria);
                    } else {
                        System.out.println("Categoria no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la categoria a eliminar: ");
                    String nombreCategoriaEliminar = scanner.nextLine();
                    biblioteca.eliminarCategoria(nombreCategoriaEliminar);
                    break;
                case 4:
                    biblioteca.mostrarCategorias();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    private static void menuAutores(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Gestion de Autores:");
            System.out.println("1. Crear Autor");
            System.out.println("2. Editar Autor");
            System.out.println("3. Eliminar Autor");
            System.out.println("4. Mostrar lista completa de Autores");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Descartar la entrada invalida
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del nuevo autor: ");
                    String nombreAutor = scanner.nextLine();
                    Autor autor = new Autor(nombreAutor);
                    biblioteca.agregarAutor(autor);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del autor a editar: ");
                    String nombreAutorEditar = scanner.nextLine();
                    Autor autorEditar = biblioteca.buscarAutor(nombreAutorEditar);
                    if (autorEditar != null) {
                        System.out.print("Ingrese el nuevo nombre del autor: ");
                        String nuevoNombreAutor = scanner.nextLine();
                        autorEditar.setNombre(nuevoNombreAutor);
                    } else {
                        System.out.println("Autor no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del autor a eliminar: ");
                    String nombreAutorEliminar = scanner.nextLine();
                    biblioteca.eliminarAutor(nombreAutorEliminar);
                    break;
                case 4:
                    biblioteca.mostrarAutores();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    private static void menuLibros(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Gestion de Libros:");
            System.out.println("1. Crear Libro");
            System.out.println("2. Editar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Mostrar lista completa de Libros");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Descartar la entrada invalida
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo del nuevo libro: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Ingrese el nombre del autor: ");
                    String nombreAutor = scanner.nextLine();
                    Autor autor = biblioteca.buscarAutor(nombreAutor);
                    System.out.print("Ingrese el nombre de la categoria: ");
                    String nombreCategoria = scanner.nextLine();
                    Categoria categoria = biblioteca.buscarCategoria(nombreCategoria);
                    if (autor != null && categoria != null) {
                        Libro libro = new Libro(tituloLibro, autor, categoria);
                        biblioteca.agregarLibro(libro);
                    } else {
                        System.out.println("Autor o categoria no existente.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el titulo del libro a editar: ");
                    String tituloLibroEditar = scanner.nextLine();
                    Libro libroEditar = biblioteca.buscarLibro(tituloLibroEditar);
                    if (libroEditar != null) {
                        System.out.print("Ingrese el nuevo titulo del libro: ");
                        String nuevoTituloLibro = scanner.nextLine();
                        libroEditar.setTitulo(nuevoTituloLibro);
                        // También se puede editar autor y categoria si es necesario
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el titulo del libro a eliminar: ");
                    String tituloLibroEliminar = scanner.nextLine();
                    biblioteca.eliminarLibro(tituloLibroEliminar);
                    break;
                case 4:
                    biblioteca.mostrarLibros();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    private static void menuPrestamos(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Prestamo de Libros:");
            System.out.println("1. Mostrar lista de libros prestados");
            System.out.println("2. Mostrar lista de libros disponibles");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Descartar la entrada invalida
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    biblioteca.mostrarLibrosPrestados();
                    break;
                case 2:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 3:
                    System.out.print("Ingrese el titulo del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    biblioteca.prestarLibro(tituloPrestar);
                    break;
                case 4:
                    System.out.print("Ingrese el titulo del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolver);
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }
}
