package mk.finki.ukim.mk.emtproject.listeners;

import mk.finki.ukim.mk.emtproject.events.ProductCreatedEvent;
import mk.finki.ukim.mk.emtproject.service.domain.ProductService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandlers {

    private final ProductService productService;

    public ProductEventHandlers(ProductService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent event) {
        this.productService.refreshMaterializedView();
    }
}

