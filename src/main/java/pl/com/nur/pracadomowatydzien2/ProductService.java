package pl.com.nur.pracadomowatydzien2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
        productList.add(new Product("Gruszki"));
        productList.add(new Product("jabłka"));
        productList.add(new Product("cukier"));
        productList.add(new Product("tofu"));
        productList.add(new Product("Olej rzepakowy"));
    }

    public void addProduct(String name){
        productList.add(new Product(name));
    }
    public void addProduct(String name, int price){
        productList.add(new Product(name, price));
    }

    public void showProduct(){
        productList.forEach(System.out::println);
    }

    public int totalPrice(){
        int totalPrice = 0;
        for (int i = 0; i < productList.size() ; i++) {
            totalPrice = totalPrice + productList.get(i).getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "productList=" + productList +
                '}';
    }
}
