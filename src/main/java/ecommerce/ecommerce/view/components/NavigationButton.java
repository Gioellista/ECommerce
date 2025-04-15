package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouteConfiguration;

@CssImport("./styles/navigationButtonStyle.css")
public class NavigationButton extends Div {

    HorizontalLayout horizontalLayout;
    Div iconContainer;
    Text buttonText;
    String text;
    Class<? extends Component> navigationClass;
    VaadinIcon icon;

    public NavigationButton(Class<? extends Component> navigationClass) {
        super();
        this.navigationClass = navigationClass;
        configure();
    }

    public NavigationButton(String text, Class<? extends Component> navigationClass) {
        super();
        this.text = text;
        this.navigationClass = navigationClass;
        configure();
    }

    private void configure() {
        setClassName("button-navigation");
        setClassNameOnCurrentLocation();
        horizontalLayout = new HorizontalLayout();
        iconContainer = new Div();
        buttonText = new Text(text);
        iconContainer.setClassName("icon-container");

        horizontalLayout.add(iconContainer, buttonText);

        add(horizontalLayout);
    }

    public void setIcon(VaadinIcon icon) {
        this.icon = icon;
        iconContainer.add(icon.create());
    }

    private void setClassNameOnCurrentLocation() {

        UI.getCurrent().getPage().fetchCurrentURL(url -> {

            String str = url.toString();
            StringBuilder res = new StringBuilder();
            int i = 0;

            while(i < str.length()) {
                if(str.charAt(i) == '/') {
                    res = new StringBuilder();
                } else {
                    res.append(str.charAt(i));
                }
                i++;
            }

            if(res.toString().equals(getURL())){
                setClassName("button-navigation-current");
                iconContainer.setClassName("icon-container-current");
            }
        });

    }

    private String getURL() {
        return RouteConfiguration.forSessionScope().getUrl(navigationClass);
    }

}
