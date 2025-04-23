package mk.finki.ukim.mk.emtproject.jobs;

import mk.finki.ukim.mk.emtproject.service.domain.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final ProductService productService;

    public ScheduledTasks(ProductService productService) {
        this.productService = productService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void refreshMaterializedView() {
        this.productService.refreshMaterializedView();
    }
}


