const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>

    .pro-card {
        //width: unset;
        //height:100%;
        background-color: var(--lumo-base-color);
        border-radius: var(--lumo-border-radius);
    }

    .pro-card-content {
        transition: width 2s;
    }

    .pro-card-title-layout {
        width: 100%;
        padding: 0px;
        background-color: var(--lumo-base-color);
   }

    .pro-card-title-icon {
        //align-self: end;
        color: var(--lumo-primary-text-color);
        min-width: var(--lumo-icon-size-m);
        min-height: var(--lumo-icon-size-m);

    }

    .pro-card-title-text {
        align-self: baseline;
        flex-grow: 1;
        font-weight: bold;
        font-size: var(--lumo-font-size-l);
    }

    .pro-card-title-action-layout {

    }

    .pro-card-title-action {
        font-size: var(--lumo-font-size-l);
    }

    .pro-card-title-expand-icon {
        align-self: end;
        color: var(--lumo-primary-text-color);
        padding: var(--lumo-space-s);
        width: var(--lumo-icon-size-m);
        //height: var(--lumo-icon-size-m);
    }

    .pro-card-title-expand-icon:hover {
        background-color: var(--lumo-contrast-5pct);
        border-radius: 50%;
    }

    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);