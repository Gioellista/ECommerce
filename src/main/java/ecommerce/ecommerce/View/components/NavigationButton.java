package ecommerce.ecommerce.View.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;

@CssImport("./styles/navigationButtonStyle.css")
public class NavigationButton extends Button {

    public NavigationButton() {
        super();
        setClassName("button-navigation");
    }

    public NavigationButton(String text) {
        super(text);
        setClassName("button-navigation");
    }
}
