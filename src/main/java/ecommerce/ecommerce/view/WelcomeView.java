package ecommerce.ecommerce.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.view.components.MainLayout;
import state.language.Language;
import state.language.LanguageString;

@CssImport("./styles/welcomeViewStyle.css")
@Route(value = "", layout = MainLayout.class)
public class WelcomeView extends VerticalLayout {

    H1 h1;
    Text text;

    public WelcomeView() {
        addClassName("welcome-view");
        setMargin(false);
        setSizeFull();
        configure();
    }

    private void configure() {

        LanguageString lsTitle = new LanguageString("Welcome to Ecommerce");
        lsTitle.addEntry(Language.ITA, "Benvenuti a ECommerce");
        lsTitle.addEntry(Language.DEU, "Wilkommen zu ECommerce");

        h1 = new H1(lsTitle.get());

        LanguageString lsText = new LanguageString("Welcome to Ecommerce, work-in-progress...");
        lsText.addEntry(Language.ITA, "Benvenuti a ECommerce, lavori in corso...");
        lsText.addEntry(Language.DEU, "Wilkommen zu ECommerce, in Arbeit...");

        text = new Text(lsText.get());

        add(h1, text);
    }
}
