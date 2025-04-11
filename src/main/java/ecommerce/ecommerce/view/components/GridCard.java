package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;

@CssImport("./styles/dynamicGridStyle.css")
public class GridCard extends Div {

    public GridCard() {
        setClassName("grid-card");

        add(new Text("Card"));
    }
}
