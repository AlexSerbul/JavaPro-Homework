package dz15;

import java.time.LocalDate;
import java.util.Random;

public class Product {
    private int id;
    private String type;
    private double price;

    private double discount;

    private LocalDate date;

    public Product(String type, double price,double discount) {
        this.id = new Random().nextInt(9999-1111)+1111;
        this.type = type;
        this.price = price;
        if(discount>price || discount<0){
            throw new IllegalArgumentException();
        }
        this.discount = discount;
        this.date = LocalDate.now();
    }

    public Product(String type, double price,double discount,LocalDate date) {
        this(type,price,discount);
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDiscountPercent(){
        return (int) ((discount/price)*100);
    }

    @Override
    public String toString() {
        return "{Type: "+type+" | Price: "+price+" | Discount: "+getDiscountPercent()+" | Дата додання: "+ date +"}\n";
    }
}
