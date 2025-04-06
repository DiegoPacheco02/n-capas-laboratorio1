package model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private List<Sale> sales = new ArrayList<>();
    private Integer totalQuantitySold = 0;

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
        if (id == null || id <= 0)
            throw new IllegalArgumentException("El ID no puede ser nulo o menor o igual a cero");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("El título no puede ser nulo o vacío");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty())
            throw new IllegalArgumentException("El autor no puede ser nulo o vacío");
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price == null || price <= 0)
            throw new IllegalArgumentException("El precio no puede ser nulo o menor o igual a cero");
        this.price = price;
    }

    public void addSale(Sale sale) {
        if (sale == null)
            throw new IllegalArgumentException("La venta no puede ser nula");
        totalQuantitySold += sale.getQuantitySold();
        sales.add(sale);
    }

    public List<Sale> getSales() {
        return sales;
    }

    public Integer getTotalQuantitySold() {
        return totalQuantitySold;
    }

    @Override
    public String toString() {
        return String.format("%d - %s de %s, con un precio de $%.2f", id, title, author, price);
    }
}
