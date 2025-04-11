package ecommerce.ecommerce.view;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.view.components.MainLayout;

@Route(value = "options", layout = MainLayout.class)
public class OptionsView extends VerticalLayout {

    public OptionsView() {
        setSizeFull();

        ComboBox<String> comboBox = new ComboBox<>("Language");
        comboBox.setItems("English", "Italian", "German");
        comboBox.setValue("English");

        add(new H1("Options"), comboBox);
    }
}
