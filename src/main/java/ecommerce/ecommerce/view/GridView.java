package ecommerce.ecommerce.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.view.components.DynamicGrid;
import ecommerce.ecommerce.view.components.GridCard;
import ecommerce.ecommerce.view.components.MainLayout;

@Route(value = "grid", layout = MainLayout.class)
public class GridView extends VerticalLayout {

    DynamicGrid grid;

    public GridView() {
        grid = new DynamicGrid();

        for(int i = 0; i < 16; i++) {
            grid.add(new GridCard());
        }

        add(grid);
    }
}
