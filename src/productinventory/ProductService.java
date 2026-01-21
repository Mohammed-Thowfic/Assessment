package productinventory;

import java.util.LinkedList;

public class ProductService {
    public ProductService() {
    }

    public LinkedList<Product> productList = new LinkedList<Product>();

    public LinkedList<Product> getStaticProductList() {
        Product product1 = new Product(101, "pen", 10.0F, 10);
        Product product2 = new Product(102, "pencil", 5.0F, 15);
        Product product3 = new Product(103, "Eraser", 3.0F, 10);
        Product product4 = new Product(104, "scale", 10.0F, 20);
        Product product5 = new Product(105, "sharpner", 8.0F, 5);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        return productList;
    }

    //
    public LinkedList<Product> addProduct(Product product) {
        productList.add(product);
        return productList;
    }

    public LinkedList<Product> removeProduct(Product product) {
        productList.remove(product);
        return productList;
    }

    public LinkedList<Product> removeProductByIndex(int indexValue) {
        if(!(indexValue > productList.size()-1)){
            productList.remove(indexValue);
        }
        return productList;
    }
    public LinkedList<Product> updateQuantity(Product p){
        p.setQuantity(p.getQuantity()+10);
        return productList;
    }

}
