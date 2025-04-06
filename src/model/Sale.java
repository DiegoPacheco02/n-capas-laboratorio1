package model;

import java.time.LocalDateTime;

public class Sale {
    private Book book;
    private Integer quantitySold;
    private LocalDateTime saleDate;

    public Sale(Book book, int quantitySold, LocalDateTime saleDate) {
        this.book = book;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
    }

    public Sale() {

    }

    public void setBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setQuantitySold(int quantitySold) {
        if (quantitySold <= 0) {
            throw new IllegalArgumentException("La cantidad vendida debe ser mayor que cero");
        }
        this.quantitySold = quantitySold;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        if (saleDate == null || saleDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de venta no puede ser nula o futura");
        }
        this.saleDate = saleDate;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void recordSale() {
        if (book == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        book.addSale(this);
    }

    public String displaySaleDetails() {
        return "{" +
                "Id: " + book.getId() + "," +
                " Libro: " + book.getTitle() + ","
                + " Fecha: " + saleDate + ","
                + " Cantidad: " + quantitySold + "}";
    }
}