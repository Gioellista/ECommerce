package ecommerce.ecommerce.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.data.Product;
import ecommerce.ecommerce.service.ProductService;
import ecommerce.ecommerce.view.components.MainLayout;

@Route(value = "upload", layout = MainLayout.class)
public class UploadView extends VerticalLayout {

    TextArea titleField;
    TextArea descriptionField;
    TextArea priceField;

    ProductService productService;

    public UploadView(ProductService productService) {
        this.productService = productService;

        setWidth("50%");

        createTitleTextFiled();
        createDescriptionTextFiled();
        createPriceTextFiled();

        Button uploadButton = new Button("Upload");

        uploadButton.addClickListener(e -> {
            Product product = new Product();
            product.setTitle(titleField.getValue());
            product.setDescription(descriptionField.getValue());
            product.setPrice(Double.parseDouble(priceField.getValue()));

            productService.save(product);

            titleField.clear();
            descriptionField.clear();
            priceField.clear();

            UI.getCurrent().getPage().reload();
        });

        add(uploadButton);
    }

    private void createTitleTextFiled() {
        titleField = new TextArea("Product Title");
        titleField.setRequiredIndicatorVisible(true);
        titleField.setRequired(true);
        titleField.setMaxRows(1);
        titleField.setMinLength(5);
        titleField.setMaxLength(60);

        titleField.setI18n(new TextArea.TextAreaI18n()
                .setRequiredErrorMessage("Field is required")
                .setMinLengthErrorMessage("Minimum length is 5 characters")
                .setMaxLengthErrorMessage("Maximum length is 60 characters"));
        add(titleField);
    }

    private void createDescriptionTextFiled() {
        descriptionField = new TextArea("Product Description");
        descriptionField.setRequiredIndicatorVisible(true);
        descriptionField.setRequired(true);
        descriptionField.setMinLength(5);
        descriptionField.setMaxLength(120);
        descriptionField.setMinRows(2);
        descriptionField.setMaxRows(5);

        descriptionField.setI18n(new TextArea.TextAreaI18n()
                .setRequiredErrorMessage("Field is required")
                .setMinLengthErrorMessage("Minimum length is 5 characters")
                .setMaxLengthErrorMessage("Maximum length is 120 characters"));
        add(descriptionField);
    }

    private void createPriceTextFiled() {
        priceField = new TextArea("Price");
        priceField.setRequiredIndicatorVisible(true);
        priceField.setRequired(true);
        priceField.setMaxRows(1);
        priceField.setPattern("^[0-9]*.[0-9]*$");
        priceField.setMinLength(1);
        priceField.setMaxLength(8);

        priceField.setI18n(new TextArea.TextAreaI18n()
                .setRequiredErrorMessage("Field is required")
                .setMinLengthErrorMessage("Minimum length is 1 characters")
                .setMaxLengthErrorMessage("Maximum length is 8 characters"));
        add(priceField);
    }
}
