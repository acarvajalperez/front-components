package es.opplus.front.components.layout;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import es.opplus.front.app.tasksinbox.domain.OpplusUser;
import org.apache.commons.lang3.StringUtils;

@CssImport(value = "./theme/profesional/components/pro-profile-card.js")
public class ProfileCard extends Div {
	private static final long serialVersionUID = 487334156312234219L;
	
	Image profileImage;

    public ProfileCard(OpplusUser opplusUser) {
        setClassName("container");

        profileImage = new Image("/img/profile_photo.png", "");
        profileImage.setClassName("profile-img");

        Div content = new Div();
        content.addClassName("content");
        Div subContent = new Div();
        subContent.addClassName("sub-content");
        H1 userName = new H1( opplusUser.getName() );
        Span email = new Span( opplusUser.getUsername() );
        
        H3 direccion = new H3("OPPLUS");
        Paragraph department = new Paragraph("");
        
        subContent.add(userName, email, direccion, department);

        Button button = new Button("Cerrar sesión");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.setClassName("btn");
        button.addClickListener( event -> {
            UI.getCurrent().getPage().setLocation("/login?logout");
        });

        content.add(subContent);
        add(profileImage, content, button);
    }

    public void setImageSrc(String src) {
    	if (StringUtils.isNotEmpty(src)) {
    		profileImage.setSrc(src);
    	}

    }
}
