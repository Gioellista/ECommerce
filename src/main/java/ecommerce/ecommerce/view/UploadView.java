package ecommerce.ecommerce.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginI18n.Form;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.data.Product;
import ecommerce.ecommerce.service.ProductService;
import ecommerce.ecommerce.view.components.MainLayout;

import java.text.Normalizer;

@Route(value = "upload", layout = MainLayout.class)
public class UploadView extends VerticalLayout {

    Form form = new Form();

    public UploadView(ProductService productService) {
    }

}
