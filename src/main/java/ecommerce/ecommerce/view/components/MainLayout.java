package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoIcon;
import ecommerce.ecommerce.view.GridView;
import ecommerce.ecommerce.view.OptionsView;
import ecommerce.ecommerce.view.WelcomeView;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createNavbar();
    }

    private void createHeader() {
        HorizontalLayout header = new HorizontalLayout();

        DrawerToggle drawer = new DrawerToggle();
        header.add(drawer);
        addToNavbar(header);

        setDrawerOpened(true);
    }

    private void createNavbar() {

        NavigationButton navigationWelcome = new NavigationButton("Welcome", WelcomeView.class);
        navigationWelcome.setIcon(VaadinIcon.INFO_CIRCLE);
        navigationWelcome.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/");
        });

        NavigationButton navigationGrid = new NavigationButton("Marketplace", GridView.class);
        navigationGrid.setIcon(VaadinIcon.CART);
        navigationGrid.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/grid");
        });

        NavigationButton navigationOptions = new NavigationButton("Options", OptionsView.class);
        navigationOptions.setIcon(VaadinIcon.COG);
        navigationOptions.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/options");
        });

        addToDrawer(navigationWelcome, navigationGrid, navigationOptions);
    }
}
