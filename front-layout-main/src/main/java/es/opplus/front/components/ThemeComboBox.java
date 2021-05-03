package es.opplus.front.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.dom.ThemeList;

public class ThemeComboBox extends ComboBox<String> {
    public ThemeComboBox() {
        super("Theme variants", "opplus", "bbva", "qipro", "ligth", "dark");
        this.addValueChangeListener(this::valueChanged);
    }

    private void valueChanged(ComponentValueChangeEvent<ComboBox<String>, String> event) {
        ThemeList themeList = UI.getCurrent().getElement().getThemeList();
        themeList.clear();
        themeList.add(event.getValue().toString());
        event.getValue();
    }
}
