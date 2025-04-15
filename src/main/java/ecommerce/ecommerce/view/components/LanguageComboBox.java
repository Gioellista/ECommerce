package ecommerce.ecommerce.view.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import state.language.Language;
import state.language.LanguageContext;
import state.language.LanguageString;

public class LanguageComboBox extends ComboBox<String> {

    public LanguageComboBox() {
        super();

        LanguageString lsLanguage = new LanguageString("Language");
        lsLanguage.addEntry(Language.ITA, "Lingua");
        lsLanguage.addEntry(Language.DEU, "Sprache");

        setLabel(lsLanguage.get());
        setItems(Language.names());
        setValue(LanguageContext.getContext().getCurrentState().name());

        addValueChangeListener(event -> {
            String val = getValue();
            LanguageContext.getContext().setCurrentState(Language.valueOf(val));
            UI.getCurrent().getPage().reload();
        });
    }
}
