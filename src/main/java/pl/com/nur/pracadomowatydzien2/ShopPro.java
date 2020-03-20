package pl.com.nur.pracadomowatydzien2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
@ConfigurationProperties(prefix = "pro")
public class ShopPro {

    ProductService productService;
    private int discount;
    private int vat;

    public ShopPro(ProductService productService) {
        this.productService = productService;
        addProduct();

    }

    public void addProduct(){
        productService.addProduct("miód pro", 449);
        productService.addProduct("sliwki pro");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showListPrice(){
        productService.showProduct();
        int netto = productService.totalPrice();
        System.out.println(" cena netto produktów "  + netto
                +  "\n cena brutto produktów " + netto * (1.0+(vat/100.0))
                +  "\n stawka vat=" +vat
                +  "\n do zapłaty po rabacie " + netto * (1.0+(vat/100.0)) *(1.0 -(discount/100.0))
                +  "\n rabat =" + discount);
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
