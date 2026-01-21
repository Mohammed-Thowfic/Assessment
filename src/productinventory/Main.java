package productinventory;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        int indexValue;
        Scanner sc=new Scanner(System.in);
        ProductService productService = new ProductService();
        LinkedList<Product> productList = productService.getStaticProductList();
        System.out.println("\nProduct Lists");
        productList.forEach(System.out::println);

        //Adding new product
        productList = productService.addProduct(new Product(106, "sketch", 30.0F, 0));
        System.out.println("\nAfter Adding new Product List");
        productList.forEach(System.out::println);

        //Update Quantity
        productList=productService.updateQuantity(productList.getFirst());
        System.out.println("\nAfter Update Quantity");
        productList.forEach(System.out::println);

        //Remove product using object
        productList = productService.removeProduct(productList.get(0));
        System.out.println("\nAfter Remove product using object");
        productList.forEach(System.out::println);

        //Remove product using index
        System.out.println("Enter index to remove product");
        indexValue=sc.nextInt();
        productList=productService.removeProductByIndex(indexValue);
        System.out.println("\nAfter Remove Product using index");
        productList.forEach(System.out::println);

        //Display Out of Stocks
        System.out.println("\nOut of Stock products");
        Predicate<Product> nullQuantity= a->a.getQuantity()==0;
        Consumer<Product> printName= print-> System.out.println(print.getProductName());
        productList.stream().filter(nullQuantity).forEach(printName);

        //Total inventory value
        System.out.println("\nCalculate total inventory value");
        double total = productList.stream().mapToDouble(p->p.getPrice()*p.getQuantity()).sum();
        System.out.println(total);
    }
}
