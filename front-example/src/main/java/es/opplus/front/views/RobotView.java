package es.opplus.front.views;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.opplus.robots.RobotLauncher;
import es.opplus.front.components.cards.CardComponent;

@PageTitle("view.inbox.robots")
@Route(value = "robots", layout = TasksInbox.class)
public class RobotView extends VerticalLayout {
    public RobotView() {
        add(addRobotCard("Avales ICO", "Automatismo que se descarga los certificados de la concesion de aavales de COVID", "logo_ico_100.png"));
        add(addRobotCard("Cambio USSV", "Automatismo para el cambio USSV", "logo_BBVA.png"));
        add(addRobotCard("Direcciones Organismos oficiales", "Automatismo para la descarga del listado de todas las direcciones de los organismos oficiales", "organismos.png"));
    }

    public CardComponent addRobotCard(String title, String description, String logo ) {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);
        layout.setSizeFull();
        layout.getStyle().set("border-style","solid");
        layout.getStyle().set("border-color","lightgray");
        layout.getStyle().set("border-width","thin");
        layout.getStyle().set("border-radius","2px");

        Image image = new Image("./img/" + logo,"logo");
        image.setHeight("32px");
        //image.setWidth("200px");

        HorizontalLayout horizontalLayout = new HorizontalLayout(new VerticalLayout(new H2(title), new Paragraph(description)), image);
        horizontalLayout.setWidthFull();

        layout.add(horizontalLayout);
        layout.add(new Button("Lanzar robot", e -> new RobotLauncher()));

        return new CardComponent(FontAwesome.Solid.ROBOT.create(), title, layout);
    }
}
