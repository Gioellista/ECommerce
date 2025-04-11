package ecommerce.ecommerce.View.components;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

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

        NavigationButton button1 = new NavigationButton("Navigation 1");
        NavigationButton button2 = new NavigationButton("Navigation 2");

        addToDrawer(button1, button2);
    }
}
