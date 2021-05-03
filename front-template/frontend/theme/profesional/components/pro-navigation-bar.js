const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
    <style>

        .nav-bar{
            font-weight: bold;
            //height: 60px;
            //box-shadow: 0px 1px 1px -1px #777;
            width: 100%;
            align-items: center;
            //padding-left: 8px;
            padding-right: 8px;
            background: var(--lumo-primary-color);
        }

        .nav-bar-logo-layout {
            padding-left: 8px;
            padding-right: 8px;
            background: var(--lumo-base-color);
            min-width: 255px;
            height: 100%;
            align-items: center;
            font-size: var(--lumo-size-xxl);
        }

        .nav-bar-logo-image {
            width: 200px;
            height: 40px;
            margin-top: 8px;
            background-image: var(--pro-logo-url);
            background-position-x: center;
            background-position-y: center;
            background-repeat: no-repeat;
            background-size: 150px 40p;
            align: center;
        }

        .nav-bar-title {
            color: var(--lumo-base-color);
            font-family: var(--lumo-font-family);
            font-size: var(--lumo-font-size-xxxl);
            width: 100%;
        }

        .nav-bar-logo {
            height: 40px;
        }

        .nav-bar-logo-layout-toggle {
            padding-left: 8px;
            padding-right: 8px;
            background: var(--lumo-base-color);
            min-width: 255px;
            height: 100%;
            align-items: center;
        }


    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);