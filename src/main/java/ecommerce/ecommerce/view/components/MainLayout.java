package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import ecommerce.ecommerce.view.GridView;
import ecommerce.ecommerce.view.OptionsView;
import ecommerce.ecommerce.view.UploadView;
import ecommerce.ecommerce.view.WelcomeView;
import state.language.Language;
import state.language.LanguageContext;
import state.language.LanguageString;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        HorizontalLayout header = new HorizontalLayout();

        DrawerToggle drawer = new DrawerToggle();

        LanguageComboBox languageComboBox = new LanguageComboBox();

        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.addToStart(drawer);
        header.addToEnd(languageComboBox);

        addToNavbar(header);

        setDrawerOpened(true);
    }

    private void createDrawer() {

        LanguageString lsWelcome = new LanguageString("Welcome");
        lsWelcome.addEntry(Language.ITA, "Benvenuti");
        lsWelcome.addEntry(Language.DEU, "Wilkommen");

        LanguageString lsMarketplace = new LanguageString("Marketplace");
        lsMarketplace.addEntry(Language.ITA, "Negozio");
        lsMarketplace.addEntry(Language.DEU, "Marktplaz");

        LanguageString lsUpload = new LanguageString("Upload");
        lsUpload.addEntry(Language.ITA, "Carica");
        lsUpload.addEntry(Language.DEU, "Hochladen");

        LanguageString lsOptions = new LanguageString("Options");
        lsOptions.addEntry(Language.ITA, "Opzioni");
        lsOptions.addEntry(Language.DEU, "Optionen");

        NavigationButton navigationWelcome = new NavigationButton(lsWelcome.get(), WelcomeView.class);
        navigationWelcome.setIcon(VaadinIcon.INFO_CIRCLE);
        navigationWelcome.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/");
        });

        NavigationButton navigationGrid = new NavigationButton(lsMarketplace.get(), GridView.class);
        navigationGrid.setIcon(VaadinIcon.CART);
        navigationGrid.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/grid");
        });

        NavigationButton navigationUpload = new NavigationButton(lsUpload.get(), UploadView.class);
        navigationUpload.setIcon(VaadinIcon.UPLOAD);
        navigationUpload.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/upload");
        });

        NavigationButton navigationOptions = new NavigationButton(lsOptions.get(), OptionsView.class);
        navigationOptions.setIcon(VaadinIcon.COG);
        navigationOptions.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/options");
        });

        addToDrawer(navigationWelcome, navigationGrid, navigationUpload, navigationOptions);
    }
}
