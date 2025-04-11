package ecommerce.ecommerce.View;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class WelcomeView extends VerticalLayout {

    public WelcomeView() {
        setSizeFull();

        add(new H1("Welcome to Ecommerce"));
    }
}
