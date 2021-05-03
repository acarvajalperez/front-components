package es.opplus.front.components.layout;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import es.opplus.front.components.ThemeComboBox;
import es.opplus.front.services.notifications.BrowserNotifications;

import java.util.Locale;
import java.util.Optional;

@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
@StyleSheet("https://fonts.googleapis.com/css?family=Montserrat")
public abstract class OpplusLayout extends AppLayout {

    private final Tabs menu;
    private H1 viewTitle;
    private NavigationBar navigationBar;

    public OpplusLayout() {

        menu = new Tabs();
        setPrimarySection(Section.DRAWER);
        navigationBar = new NavigationBar(
                new Span("NavBar"),
                "Bandeja de tareas",
                new Button(FontAwesome.Solid.BELL.create()),
                new Avatar("Antonio Carvajal")
        );
        addToNavbar(navigationBar);
        createMenu();
        addToDrawer(createDrawerContent());

        /*
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();

            String preferredUsername = keycloakSecurityContext.getIdToken().getPreferredUsername();

            Anchor logout = new Anchor(
                    "http://localhost:9991/auth/realms/Demo/protocol/openid-connect/logout?redirect_uri=" +
                            "http://localhost:9998/",
                    "Logout");

            setContent(new HorizontalLayout(new Span(preferredUsername), logout));
        } else {
            setContent(new Span("No Logged in User"));
        }
         */
    }

    /*
    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("opplus", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);
        layout.add(new Avatar("Antonio Carvajal"));
        return layout;
    }
     */

    private Component createDrawerContent() {

        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setClassName("pro-drawer-header");
        logoLayout.setWidthFull();
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        HorizontalLayout themeLayout = new HorizontalLayout(new ThemeComboBox());
        themeLayout.setWidthFull();
        themeLayout.setPadding(true);

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        menu.setHeightFull();
        layout.add(logoLayout, menu, themeLayout);
        return layout;
    }

    private void createMenu() {
        menu.setOrientation(Tabs.Orientation.VERTICAL);
        menu.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        menu.setId("tabs");
        menu.add(createMenuItems());
        menu.addSelectedChangeListener(listener -> {
            Tab tab = listener.getSelectedTab();
            if (tab != null)
                UI.getCurrent().navigate(ComponentUtil.getData(tab, Class.class));
        });
    }

    protected abstract Component[] createMenuItems(); /* {
        return new Tab[]{
                createTab(FontAwesome.Solid.INBOX.create(), "Enlace 1", new Label("132"), Enlace1.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Enlace 2", null, Enlace2.class)/*,
                createTab(FontAwesome.Solid.CHART_AREA.create(), "Informes", new Label("132"), HelloWorldView.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Operaciones", new Label("132"), OperationsView.class)
        };
    }*/

    protected Tab createMenuItem(IronIcon icon, String text, Component suffix, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();

        icon.setSize("32px");

        Label tabText = new Label(text);
        tabText.getStyle().set("margin-left", "10px");
        //tabText.setClassName("drawer-menu-label");
        tabText.setWidthFull();

        tab.add(icon, tabText);
        if (suffix != null)
            tab.add(suffix);
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();

        Optional<Tab> tab = getTabForComponent(getContent());
        if (tab.isPresent())
            menu.setSelectedTab(tab.get());
        else
            menu.setSelectedTab(null);

        //viewTitle.setText(getCurrentPageTitle());
        //String title = getTranslation("view.about.title", Locale.getDefault());
        navigationBar.setTitleComponent(getTranslation(getCurrentPageTitle()));
        BrowserNotifications.extend(UI.getCurrent()).askForPermission();
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
