package pl.com.nur.pracadomowatydzien2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@ConfigurationProperties(prefix = "price-conf")
public class Product {

    private int priceMin;
    private int priceMax=300;// dlaczego nie mogę ustawić @ConfigurationProperties

    private String name;
    private int price;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
        randomPrice();
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    private int randomPrice(){

        Random generator = new Random();
        price = generator.nextInt(priceMax-priceMin) + priceMin;
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
