package pl.com.nur.pracadomowatydzien2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("start")
public class ShopStart {

    ProductService productService;

    public ShopStart(ProductService productService) {
        this.productService = productService;
        addProduct();
    }

    public void addProduct(){
        productService.addProduct("miód start", 49);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showListPrice(){
        productService.showProduct();
        System.out.println(" cena netto produktów " + productService.totalPrice());
    }


}
