package pl.com.nur.pracadomowatydzien2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("plus")
@ConfigurationProperties(prefix = "tax")
public class ShopPlus {

    ProductService productService;
    private int vat;

    public ShopPlus(ProductService productService) {
        this.productService = productService;
        addProduct();

    }

    public void addProduct(){
        productService.addProduct("miód plus", 149);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showListPrice(){
        productService.showProduct();
        int netto = productService.totalPrice();
        System.out.println(" cena netto produktów "  + netto
                      +  "\n cena brutto produktów " + netto * (1.0+(vat/100.0))
                      +  "\n stawka vat=" +vat);
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
}
