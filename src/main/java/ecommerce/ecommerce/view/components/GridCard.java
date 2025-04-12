package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import ecommerce.ecommerce.data.Product;

@CssImport("./styles/dynamicGridStyle.css")
public class GridCard extends VerticalLayout {

    Product product;

    public GridCard(Product product) {
        this.product = product;
        setClassName("grid-card");

        add(
                new H3(product.getTitle()),
                new Div(product.getDescription()),
                new Div(String.valueOf(product.getPrice()))
        );
    }
}
