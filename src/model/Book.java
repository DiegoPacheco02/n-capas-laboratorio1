package model;

import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private List<Sale> sales;

    public Book() {
    }

    public Book(Long id, String title, String author, Double price, List<Sale> sales) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void recordSale(Sale sale) {
        sales.add(sale);
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
