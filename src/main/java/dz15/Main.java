package dz15;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book",70,27));
        products.add(new Product("Magazine",456,14));
        products.add(new Product("Book",30,0, LocalDate.of(2021,01,01)));
        products.add(new Product("Book",280,45));
        products.add(new Product("Magazine",74,0,LocalDate.of(2022,01,01)));
        products.add(new Product("Book",24,4,LocalDate.of(2023,01,01)));

        try {
            //System.out.println(filterBooksOverTwoFifty(products));
            //System.out.println(filterBooksWithDiscountEqualTen(products));
            //System.out.println(getCheapestBook(products));
            //System.out.println(getLastThree(products));
            //System.out.println(TotalPriceForBooksFromThisYear(products));
            System.out.println(getMapByType(products));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


    }

    private static List<Product> filterBooksOverTwoFifty(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getPrice()>250)
                .toList();
    }
    private static List<Product> filterBooksWithDiscountEqualTen(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getDiscountPercent()==10)
                .toList();
    }

    private static Product getCheapestBook(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NullPointerException("Продукт: Book  не знайдено"));
    }

    private static List<Product> getLastThree(List<Product> products){
        return products.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .toList();
    }

    private static double TotalPriceForBooksFromThisYear(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getDate().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice).sum();
    }

    private static Map<String,List<Product>> getMapByType(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
