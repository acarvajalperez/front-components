package es.opplus.front.components.layout;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
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
import es.opplus.front.app.tasksinbox.domain.OpplusUser;
import es.opplus.front.components.ThemeComboBox;
import es.opplus.front.components.dialog.ProfileDialog;
import es.opplus.front.services.notifications.BrowserNotifications;

import java.util.Optional;

@CssImport("./styles/views/main/main-view.css")

@JsModule("./styles/shared-styles.js")
@JsModule("./theme/profesional/components/pro-drawer.js")
@JsModule("./theme/profesional/components/pro-navigation-bar.js")
@StyleSheet("https://fonts.googleapis.com/css?family=Montserrat")

public abstract class OpplusLayout extends AppLayout {

    private final Tabs menu;
    private Drawer drawer;
    private NavigationBar navigationBar;

    protected OpplusLayout() {

        menu = new Tabs();
        //setPrimarySection(Section.DRAWER);

        Span logo = new Span();
        logo.setClassName("nav-bar-logo-image");

        navigationBar = new NavigationBar(
                logo,
                "Bandeja de tareas",
                new Button(FontAwesome.Solid.BELL.create(), listener -> {
                    ProfileDialog profileDialog = new ProfileDialog(new OpplusUser());
                    //profileDialog.setImageSrc(urlImg);
                    profileDialog.setCloseOnEsc(true);
                    profileDialog.setCloseOnOutsideClick(true);
                    profileDialog.open();
                })
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

    public void setNavigationBar(NavigationBar navigationBar) {
        this.navigationBar = navigationBar;
        addToNavbar(navigationBar);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public void setAvatar(Avatar avatar) {
        navigationBar.setAvatar(avatar);
    }

    private Component createDrawerContent() {

        HorizontalLayout themeLayout = new HorizontalLayout(new ThemeComboBox());
        themeLayout.setWidthFull();
        themeLayout.setPadding(true);

        Button newOperationButton = new Button("Nueva operación");
        newOperationButton.setIcon(FontAwesome.Solid.PLUS.create());
        newOperationButton.addClassName("pro-drawer-new_operation-button");
        newOperationButton.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY);
        newOperationButton.setWidthFull();

        /*
        newOperationButton.addClickListener(event -> {
            UI.getCurrent().navigate(NewOperationView.class);
        });
         */

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        menu.setHeightFull();

        layout.add(menu);
        drawer = new Drawer();
        drawer.setHeader(newOperationButton);
        drawer.setContent(layout);
        drawer.setFooter(themeLayout);
        return drawer;
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

    protected abstract Component[] createMenuItems();
    /* {
        return new Tab[]{
                createTab(FontAwesome.Solid.INBOX.create(), "Enlace 1", new Label("132"), Enlace1.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Enlace 2", null, Enlace2.class)/*,
                createTab(FontAwesome.Solid.CHART_AREA.create(), "Informes", new Label("132"), HelloWorldView.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Operaciones", new Label("132"), OperationsView.class)
        };
    }*/

    protected Tab createMenuItem(IronIcon icon, String text, Component suffix, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        icon.setSize("32px");

        Label tabText = new Label(text);
        //tabText.getStyle().set("margin-left", "10px");
        //tabText.setClassName("pro-drawer-group-item");
        tabText.setWidthFull();

        horizontalLayout.add(icon, tabText);
        if (suffix != null)
            horizontalLayout.add(suffix);

        tab.add(horizontalLayout);
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
