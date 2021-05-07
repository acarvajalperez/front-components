package es.opplus.front.components.cards;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import es.opplus.front.components.actions.HasActions;
import lombok.Getter;

@JsModule("./theme/profesional/components/pro-card.js")
public class CardComponent extends VerticalLayout {

	@Getter private HorizontalLayout titleLayout;
	private HorizontalLayout actionsLayout;
	@Getter private Component content;
	private IronIcon titleIcon;
	private Label titleText;
	private Button expandButton;
	private IronIcon expandIconOn;
	private IronIcon expandIconOff;

	public CardComponent(IronIcon icon, String title, Component component) {
		super();

		content = component;
		addClassName("pro-card");

		titleIcon = icon;
		titleIcon.addClassName("pro-card-title-icon");

		titleText = new Label(title);
		titleText.addClassName("pro-card-title-text");

		expandIconOn = FontAwesome.Solid.ANGLE_DOWN.create();
		expandIconOff = FontAwesome.Solid.ANGLE_RIGHT.create();

		expandButton = new Button(expandIconOn);
		expandButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		expandButton.addClickListener(listener -> {
			content.setVisible(!content.isVisible());
		});

		actionsLayout = new HorizontalLayout();

		titleLayout = new HorizontalLayout(titleIcon,
				titleText /* , actionsLayout/*, addConversationButton, actionsLayout , expandButton */);
		titleLayout.addClassName("pro-card-title-layout");
		add(titleLayout, component);
	}

	@Override
	public void add(Component... components) {
		for (Component item : components) {
			if (item instanceof HasActions)
				for (Button action : ((HasActions) item).getActions())
					addAction(action);
			super.add(item);
		}
	}

	private CardComponent addAction (Button action) {
		if (action != null) {
			action.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			action.getStyle().set("background-color", "var(--lumo-primary-text-color)");
			action.setClassName("pro-card-title-action");
			titleLayout.add(action);
		}
		return this;
	}

	public void setTitle(String title) {
		titleText.setText(title);
	}
}
