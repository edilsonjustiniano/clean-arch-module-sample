package module.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "module.delivery.config",
        "module.dataprovider.aurora.config",
        "module.delivery.rest.impl",
        "module.core.usecase.core"
})
public class ModuleApplication {

    public static void main(String[] args) {
        System.out.println("Application starting...");
        SpringApplication.run(ModuleApplication.class, args);
    }
}
