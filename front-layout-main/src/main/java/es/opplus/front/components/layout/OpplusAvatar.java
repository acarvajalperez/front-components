package es.opplus.front.components.layout;

import com.vaadin.flow.component.avatar.Avatar;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.jwt.auth.principal.DefaultJWTCallerPrincipal;

public class OpplusAvatar extends Avatar {

    public OpplusAvatar(SecurityIdentity identity) {
        if (identity.getPrincipal() instanceof DefaultJWTCallerPrincipal) {
            DefaultJWTCallerPrincipal jwt = (DefaultJWTCallerPrincipal)identity.getPrincipal();
            this.setName(jwt.getName());
            this.setHeight("60px");
            System.out.println(jwt);
        }
    }
}
