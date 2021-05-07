package es.opplus.front.components.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@JsModule("./theme/profesional/components/pro-drawer.js")
public class Drawer extends VerticalLayout {

    HorizontalLayout header;
    VerticalLayout content;
    HorizontalLayout footer;

    public Drawer() {
        super();
        this.setId("pro-drawer");
        this.setClassName("pro-drawer");
        this.setPadding(false);
        this.setSpacing(false);
        this.setHeightFull();
        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Header
        header = new HorizontalLayout();
        //header.addClassName("pro-drawer-header");
        header.setPadding(false);
        header.setSpacing(false);

        // Content
        content = new VerticalLayout();
        content.addClassName("pro-drawer-content");
        content.setHeightFull();
        content.setPadding(false);
        content.setSpacing(false);

        // Footer
        footer = new HorizontalLayout();
        footer.addClassName("pro-drawer-footer");
        footer.setPadding(false);
        footer.setSpacing(false);

        add(header, content, footer);
    }

    public Drawer(Component header, Component content, Component footer) {
        this();
        if (header != null) this.setHeader(header);
        if (content != null) this.setContent(content);
        if (footer != null) this.setFooter(footer);
    }

    public Component getHeader() {
        return header.getComponentAt(0);
    }

    public void setHeader(Component header) {
        this.header.removeAll();
        this.header.setPadding(true);
        this.header.add(header);
    }

    public Component getContent() {
        return content.getComponentAt(0);
    }

    public void setContent(Component... content) {
        this.content.removeAll();
        this.content.add(content);
    }

    public Drawer addContent(Component... content) {
        this.content.add(content);
        return this;
    }

    public Component getFooter() {
        return footer.getComponentAt(0);
    }

    public Drawer setFooter(Component footer) {
        this.footer.removeAll();
        this.footer.setPadding(true);
        this.footer.add(footer);
        return this;
    }
}