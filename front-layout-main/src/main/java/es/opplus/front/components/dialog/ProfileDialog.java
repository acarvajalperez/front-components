package es.opplus.front.components.dialog;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import es.opplus.front.app.tasksinbox.domain.OpplusUser;
import es.opplus.front.components.layout.ProfileCard;

/**
 * A dialog component providing a convenient base structure that is suitable for
 * most message, confirmation, question dialogs.
 */
@CssImport(value = "./theme/profesional/components/pro-profile-card.js")
public class ProfileDialog extends Dialog {

	private static final long serialVersionUID = -1350071063892409720L;
	private ProfileCard profileCard;

	public ProfileDialog(OpplusUser opplusUser) {
		setCloseOnEsc(false);
		setCloseOnOutsideClick(false);
		profileCard = new ProfileCard(opplusUser);
		add(profileCard);
		//getElement().setAttribute("theme", "profile-card");
	}

	public void setImageSrc(String src) {
		profileCard.setImageSrc(src);
	}
}
