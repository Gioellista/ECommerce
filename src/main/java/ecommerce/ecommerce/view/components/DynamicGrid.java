package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;

@CssImport("./styles/dynamicGridStyle.css")
public class DynamicGrid extends Div {

    public DynamicGrid() {
        setClassName("dynamic-grid");
    }
}
