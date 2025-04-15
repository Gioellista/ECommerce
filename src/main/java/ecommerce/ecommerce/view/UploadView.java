package ecommerce.ecommerce.view;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import ecommerce.ecommerce.data.Product;
import ecommerce.ecommerce.service.ProductService;
import ecommerce.ecommerce.view.components.MainLayout;
import state.language.Language;
import state.language.LanguageString;

@CssImport("./styles/productFormStyle.css")
@Route(value = "upload", layout = MainLayout.class)
public class UploadView extends VerticalLayout {

    TextField title;
    TextArea description;
    TextField price;
    Button upload;

    private Product product;

    ProductService productService;

    public UploadView(ProductService productService) {
        addClassName("product-form");
        setMargin(false);
        this.productService = productService;

        LanguageString lsPageTitle = new LanguageString("Upload Product");
        lsPageTitle.addEntry(Language.ITA, "Carica Prodotto");
        lsPageTitle.addEntry(Language.DEU, "Produkt hochladen");

        H1 h1 = new H1(lsPageTitle.get());

        LanguageString lsTitle = new LanguageString("Title");
        lsTitle.addEntry(Language.ITA, "Titolo");
        lsTitle.addEntry(Language.DEU, "Titel");

        LanguageString lsDescription = new LanguageString("Description");
        lsDescription.addEntry(Language.ITA, "Descrizione");
        lsDescription.addEntry(Language.DEU, "Beschreibung");

        LanguageString lsPrice = new LanguageString("Price");
        lsPrice.addEntry(Language.ITA, "Prezzo");
        lsPrice.addEntry(Language.DEU, "Preis");

        LanguageString lsUpload = new LanguageString("Upload");
        lsUpload.addEntry(Language.ITA, "Carica");
        lsUpload.addEntry(Language.DEU, "Hochladen");

        title = new TextField(lsTitle.get());
        description = new TextArea(lsDescription.get());
        price = new TextField(lsPrice.get());
        upload = new Button(lsUpload.get());
        configure();

        add(h1, title, description, price, upload);
    }

    private void configure() {
        title.setMinLength(5);
        title.setMaxLength(50);
        title.setRequiredIndicatorVisible(true);
        description.setMinLength(5);
        description.setMinRows(6);
        description.setRequiredIndicatorVisible(true);
        price.setPattern("^[0-9]+.[0-9]*$");
        price.setRequiredIndicatorVisible(true);

        title.setWidth("100%");
        title.setWidthFull();
        description.setWidth("100%");
        description.setWidthFull();
        price.setWidth("100%");
        price.setWidthFull();

        configureWrongFormats();

        upload.addClickListener(event -> {
            product = new Product();

            product.setTitle(title.getValue());
            product.setDescription(description.getValue());
            product.setPrice(Double.parseDouble(price.getValue()));

            if(!(title.isInvalid() || description.isInvalid() || price.isInvalid())) {
                productService.save(product);
                UI.getCurrent().getPage().reload();
            }
        });
    }

    private void configureWrongFormats() {

        LanguageString lsRequired = new LanguageString("Field is required");
        lsRequired.addEntry(Language.ITA, "Campo obbligatorio");
        lsRequired.addEntry(Language.DEU, "Dieses Feld ist erforderlich");

        LanguageString lsInvalid = new LanguageString("Invalid price format");
        lsInvalid.addEntry(Language.ITA, "Formato prezzo invalido");
        lsInvalid.addEntry(Language.DEU, "Ungültiges Preisformat");

        LanguageString lsMin5 = new LanguageString("Minimum length is 5 characters");
        lsMin5.addEntry(Language.ITA, "Lunghezza minima: 5 caratteri");
        lsMin5.addEntry(Language.DEU, "Die Mindestlänge beträgt 5 Zeichen");

        LanguageString lsMax50 = new LanguageString("Maximum length is 50 characters");
        lsMax50.addEntry(Language.ITA, "Lunghezza massima: 50 caratteri");
        lsMax50.addEntry(Language.DEU, "Die maximale Länge beträgt 5 Zeichen");

        title.setI18n(new TextField.TextFieldI18n()
                .setRequiredErrorMessage(lsRequired.get())
                .setMinLengthErrorMessage(lsMin5.get())
                .setMaxLengthErrorMessage(lsMax50.get()));

        description.setI18n(new TextArea.TextAreaI18n()
                .setRequiredErrorMessage(lsRequired.get())
                .setMinLengthErrorMessage(lsMin5.get()));

        price.setI18n(new TextField.TextFieldI18n()
                .setRequiredErrorMessage(lsRequired.get())
                .setPatternErrorMessage(lsInvalid.get()));
    }

}
