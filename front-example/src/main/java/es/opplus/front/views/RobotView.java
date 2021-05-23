package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.robots.RobotLauncher;
import es.opplus.front.components.cards.CardComponent;

/**
  *
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("view.inbox.robots")
@Route(value = "robots", layout = TasksInbox.class)
public class RobotView extends VerticalLayout {
    public RobotView() {

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);
        layout.setSizeFull();
        layout.getStyle().set("border-style","solid");
        layout.getStyle().set("border-color","lightgray");
        layout.getStyle().set("border-width","thin");
        layout.getStyle().set("border-radius","2px");

        layout.add(new H2("Direcciones organismos oficiales"));
        layout.add(new Paragraph("Este robot descarga las direcciones de todos los organismos oficiales."));
        layout.add(new Button("Start", e -> new RobotLauncher()));

        CardComponent card = new CardComponent(FontAwesome.Solid.ROBOT.create(), "Demostración de lanzadera de robots", layout);
        add(card);
    }
}
