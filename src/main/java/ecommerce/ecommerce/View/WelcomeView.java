package ecommerce.ecommerce.View;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.View.components.MainLayout;

@Route(value = "", layout = MainLayout.class)
public class WelcomeView extends VerticalLayout {


    public WelcomeView() {
        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        Button errorButton = new Button("Error");
        errorButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);

        setSizeFull();

        add(new H1("Welcome to Ecommerce"));
        add(new Text("Welcome to Ecommerce Description"));
        add(primaryButton, errorButton);
    }
}
