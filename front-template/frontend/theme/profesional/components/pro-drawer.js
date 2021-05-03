const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>

      :host(:not([dir='rtl']):not([overlay])) [part='drawer'] {
          border-right: 0px;
      }

    .pro-drawer {
    	//background: var(--lumo-contrast-5pct);
    	background: var(--lumo-base-color);
    	//box-shadow: 0px 0px 0px 0px red;
        border-right-width: var(--lumo-space-l);
    }

    .pro-drawer-header {
        //width: 200px;
        width: 100%;
        height: 40px;
        margin-top: 16px;
        align-items: center;
        background-image: var(--pro-logo-url);
        background-position-x: center;
        background-position-y: center;
        background-repeat: no-repeat;
    }

    .pro-drawer-header:hover {
      	//background: var(--lumo-contrast-5pct);
    }

    .pro-drawer-content {
        border-right-style: solid;
        border-color: white;
        border-right-width: var(--lumo-space-m);
    }

    .pro-drawer-footer {
        align-items: center;
    	//background: var(--lumo-contrast-5pct);
    }

    .pro-drawer-submenu-content-layout {
        margin: 0px;
        padding-top: var(--lumo-space-m);
        padding-bottom: var(--lumo-space-m);
        padding-right: 0px;
        padding-left: var(--lumo-space-m);
    }

    .pro-drawer-submenu:hover {
        background: var(--lumo-contrast-5pct);
    }

    .pro-drawer-tab {
        height: 50px;
    }

    .pro-drawer-new_operation-button {
        width: 100%;
        border-radius: 20px;
        margin-left: 2em;
        margin-right: 2em;
    }

    .pro-drawer-tab:hover {
        color: var(--lumo-primary-text-color);
        background: var(--lumo-contrast-5pct);
    }

    .pro-drawer-tab[selected] {
        color: var(--lumo-primary-text-color);
        font-weight: bold;
        background: var(--lumo-contrast-10pct);
    }

    .pro-drawer-group-item {
        width: 100%;
        padding: var(--lumo-space-s);
        color: var(--lumo-secondary-text-color);
        background-color: var(--lumo-base-color);
        border-top-right-radius: 2em;
        border-bottom-right-radius: 2em;
    }

    .pro-drawer-group-item:hover {
        font-weight: bold;
        color: var(--lumo-primary-text-color);
        background-color: var(--lumo-contrast-20pct);
    }

    .pro-drawer-group-item-selected {
        font-weight: bold;
        color: var(--lumo-primary-text-color);
        background-color: var(--lumo-contrast-10pct);
        //border-left-style: solid;
    }

    .pro-drawer-group-item-selected:hover {
        background-color: var(--lumo-contrast-20pct);
    }

    .pro-drawer-group-item-counter {
        padding-right: var(--lumo-icon-size-m);
        text-align: end;
    }

    .pro-drawer-group-item-icon {
        width: 3.5em;
        height: 1.5em;
        margin-left: 1em;
        //min-width: calc (var(--lumo-icon-size-l) * 0.5);
        //min-height: calc (var(--lumo-icon-size-m) * 0.5);
    }

    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);