package ecommerce.ecommerce;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(value = "night-theme", variant = Lumo.DARK)
public class ECommerceApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
