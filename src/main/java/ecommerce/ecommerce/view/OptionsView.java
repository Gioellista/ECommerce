package ecommerce.ecommerce.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ecommerce.ecommerce.view.components.LanguageComboBox;
import ecommerce.ecommerce.view.components.MainLayout;
import state.currency.Currency;
import state.currency.CurrencyFormula;
import state.currency.CurrencyContext;
import state.currency.CurrencyNumber;
import state.language.Language;
import state.language.LanguageContext;
import state.language.LanguageString;

import java.util.Collection;
import java.util.HashSet;

@Route(value = "options", layout = MainLayout.class)
public class OptionsView extends VerticalLayout {

    public OptionsView() {
        setSizeFull();

        LanguageString ls = new LanguageString("Options");
        ls.addEntry(Language.ITA, "Opzioni");
        ls.addEntry(Language.DEU, "Optionen");

        add(new H1(ls.get()));
        createComboBoxLanguage();
        createComboBoxCurrency();
    }

    public void createComboBoxLanguage() {

        LanguageComboBox languageComboBox = new LanguageComboBox();
        add(languageComboBox);
    }

    public void createComboBoxCurrency() {

        LanguageString lsCurrency = new LanguageString("Currency");
        lsCurrency.addEntry(Language.ITA, "Moneta");
        lsCurrency.addEntry(Language.DEU, "Wärung");

        ComboBox<String> comboBox = new ComboBox<>(lsCurrency.get());
        comboBox.setItems(
                Currency.names()
        );
        comboBox.setValue(CurrencyContext.getContext().getCurrentState().name());

        comboBox.addValueChangeListener(event -> {
            String val = comboBox.getValue();
            CurrencyContext.getContext().setCurrentState(Currency.valueOf(val));
            UI.getCurrent().getPage().reload();
        });
        add(comboBox);
    }
}