package model;

import java.time.LocalDateTime;

public class Sale {
    private Book book;
    private int quantitySold;
    private LocalDateTime saleDate;

 public Sale(){
     this.book = new Book();
 }

public Sale(Book book, int quantitySold, LocalDateTime saleDate) {
    this.book = book;
    this.quantitySold = quantitySold;
    this.saleDate = saleDate;
    }
}

public Book getBook(){return Book}

public void setQuantitySold(int quantitySold){return this.quantitySold = quantitySold}

public int getQuantitySold(){return quantitySold}

public void setSaleDate(LocalDateTime saleDate){
    this.saleDate = saleDate;
}

public LocalDateTime getSaleDate(){
    return saleDate;
}

public void recordSale(){}

public String displaySaleDetails(){

}