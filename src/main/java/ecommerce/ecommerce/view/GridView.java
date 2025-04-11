package ecommerce.ecommerce.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.data.Product;
import ecommerce.ecommerce.service.ProductService;
import ecommerce.ecommerce.view.components.DynamicGrid;
import ecommerce.ecommerce.view.components.GridCard;
import ecommerce.ecommerce.view.components.MainLayout;

import java.util.List;

@Route(value = "grid", layout = MainLayout.class)
public class GridView extends VerticalLayout {

    ProductService productService;
    DynamicGrid grid;

    public GridView(ProductService productService) {
        this.productService = productService;
        grid = new DynamicGrid();
        updateProducts();
        add(grid);
    }

    private void updateProducts() {
        grid.removeAll();
        List<Product> products = productService.findAll();
        for (Product p : products) {
            grid.add(new GridCard(p));
        }
    }
}
