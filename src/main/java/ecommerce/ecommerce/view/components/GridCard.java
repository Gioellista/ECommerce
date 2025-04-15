package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import ecommerce.ecommerce.data.Product;
import state.currency.CurrencyNumber;
import state.currency.CurrencySymbol;
import state.currency.CurrencyFormula;

@CssImport("./styles/dynamicGridStyle.css")
public class GridCard extends VerticalLayout {

    Product product;

    public GridCard(Product product) {
        this.product = product;
        setClassName("grid-card");

        double value = product.getPrice();
        CurrencySymbol currencySymbol = new CurrencySymbol();
        CurrencyNumber currencyNumber = new CurrencyNumber(value);

        add(
                new H3(product.getTitle()),
                new Div(product.getDescription()),
                new Text(currencySymbol.get() + " " + currencyNumber.get())
        );
    }
}
