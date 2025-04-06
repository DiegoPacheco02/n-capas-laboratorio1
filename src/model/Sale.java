package model;

import java.time.LocalDateTime;

public class Sale {
    private Book book;
    private int quantitySold;
    private LocalDateTime saleDate;

    public Sale(Book book, int quantitySold, LocalDateTime saleDate) {
        this.book = book;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
    }

    public Sale(){

    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public String displaySaleDetails() {
        return "{" +
                "Id: " + book.getId() + "," +
                " Libro: " + book.getTitle() + ","
                + " Fecha: " + saleDate + ","
                + " Cantidad: " + quantitySold + "}";
    }
}