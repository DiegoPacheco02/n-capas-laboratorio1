import model.Book;
import model.Sale;
import service.BookService;

import java.time.LocalDateTime;

import static utils.TerminalUtils.getValueFromTerminal;

public class Main {
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {
        int option;
        do {
            displayMenu();
            option = getOptionFromTerminal();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    recordSale();
                    break;
                case 3:
                    showBestSellingBook();
                    break;
                case 4:
                    showBooksWithWithMoreThanXSales();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
    }

    private static void displayMenu() {
        System.out.println("1. Agregar libro");
        System.out.println("2. Registrar venta");
        System.out.println("3. Mostrar libro más vendido de la libreria");
        System.out.println("4. Mostrar libros con más de X ventas");
        System.out.println("0. Salir");
    }

    private static Integer getOptionFromTerminal() {
        try {
            return getValueFromTerminal("Seleccione una opción: ", Integer.class);
        } catch (Exception e) {
            System.out.println("La opción debe ser un número entero.");
            return -1;
        }
    }

    private static void addBook() {
        try {
            Book newBook = new Book();
            newBook.setId(getValueFromTerminal("Ingrese el ID del libro: ", Long.class));
            newBook.setTitle(getValueFromTerminal("Ingrese el título del libro: ", String.class));
            newBook.setAuthor(getValueFromTerminal("Ingrese el autor del libro: ", String.class));
            newBook.setPrice(getValueFromTerminal("Ingrese el precio del libro: ", Double.class));

            bookService.saveBook(newBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar el libro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private static void recordSale() {
        try {
            Sale sale = new Sale();
            Long bookId = getValueFromTerminal("Ingrese el ID del libro vendido: ", Long.class);
            Book book = bookService.getBookById(bookId);

            if (book == null)
                throw new IllegalArgumentException("Libro no encontrado con el ID " + bookId);
            sale.setBook(book);
            sale.setQuantitySold(getValueFromTerminal("Ingrese la cantidad vendida: ", Integer.class));
            sale.setSaleDate(LocalDateTime.now());

            sale.recordSale();
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private static void showBestSellingBook() {
        try {
            Book bestSellingBook = bookService.getBestSellingBook();
            if (bestSellingBook != null) {
                System.out.printf(
                        "El libro más vendido es: %s, que se ha vendido %d veces%n",
                        bestSellingBook,
                        bestSellingBook.getTotalQuantitySold());
            } else {
                System.out.println("No hay libros registrados.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al mostrar el libro más vendido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private static void showBooksWithWithMoreThanXSales() {
        try {
            int x = getValueFromTerminal("Ingrese el numero de ventas minimo que desea consultar ", Integer.class);
            if (x < 0)
                throw new IllegalArgumentException("El numero de ventas no puede ser negativo");

            bookService.getBooksWithMoreThanXSales(x)
                    .forEach(book -> {
                        System.out.printf("%s tiene %d ventas %n", book,
                                book.getTotalQuantitySold());
                    });
        } catch (IllegalArgumentException e) {
            System.out.println("Error al mostrar los libros con mas de X ventas: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}