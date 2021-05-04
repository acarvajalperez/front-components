// eagerly import theme styles so as we can override them
import "@vaadin/vaadin-lumo-styles/all-imports";
//import "@vaadin/vaadin-charts/theme/vaadin-chart-default-theme";

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>
    html {

        --lumo-font-family: "Montserrat", 'ubuntu', "Ubuntu", "Roboto", "Segoe UI", Helvetica, Arial, sans-serif;

        --lumo-font-size: 1rem;
        --lumo-font-size-xxxl: 1.375rem;
        --lumo-font-size-xxl: 1.125rem;
        --lumo-font-size-xl: 1rem;
        --lumo-font-size-l: 0.875rem;
        --lumo-font-size-m: 0.75rem;
        --lumo-font-size-s: 0.6875rem;
        --lumo-font-size-xs: 0.625rem;
        --lumo-font-size-xxs: 0.625rem;

        --lumo-size-xl: 2.5rem;
        --lumo-size-l: 2rem;
        --lumo-size-m: 1.75rem;
        --lumo-size-s: 1.5rem;
        --lumo-size-xs: 1.25rem;

        --lumo-icon-size-s: 1em;
        --lumo-icon-size-m: 1.25em;
        --lumo-icon-size-l: 1.75em;

        --lumo-space-xl: 1.75rem;
        --lumo-space-l: 1.125rem;
        --lumo-space-m: 0.5rem;
        --lumo-space-s: 0.25rem;
        --lumo-space-xs: 0.125rem;

        --lumo-tint-5pct: hsla(0, 0%, 100%, 0.3);
        --lumo-tint-10pct: hsla(0, 0%, 100%, 0.37);
        --lumo-tint-20pct: hsla(0, 0%, 100%, 0.44);
        --lumo-tint-30pct: hsla(0, 0%, 100%, 0.5);
        --lumo-tint-40pct: hsla(0, 0%, 100%, 0.57);
        --lumo-tint-50pct: hsla(0, 0%, 100%, 0.64);
        --lumo-tint-60pct: hsla(0, 0%, 100%, 0.7);
        --lumo-tint-70pct: hsla(0, 0%, 100%, 0.77);
        --lumo-tint-80pct: hsla(0, 0%, 100%, 0.84);
        --lumo-tint-90pct: hsla(0, 0%, 100%, 0.9);
        --lumo-tint: #FFF;

        --lumo-shade-5pct: hsla(214, 61%, 25%, 0.05);
        --lumo-shade-10pct: hsla(214, 57%, 24%, 0.1);
        --lumo-shade-20pct: hsla(214, 53%, 23%, 0.16);
        --lumo-shade-30pct: hsla(214, 50%, 22%, 0.26);
        --lumo-shade-40pct: hsla(214, 47%, 21%, 0.38);
        --lumo-shade-50pct: hsla(214, 45%, 20%, 0.5);
        --lumo-shade-60pct: hsla(214, 43%, 19%, 0.61);
        --lumo-shade-70pct: hsla(214, 42%, 18%, 0.72);
        --lumo-shade-80pct: hsla(214, 41%, 17%, 0.83);
        --lumo-shade-90pct: hsla(214, 40%, 16%, 0.94);
        --lumo-shade: hsl(214, 35%, 15%);

        --lumo-contrast-5pct: hsla(214, 61%, 25%, 0.05);
        --lumo-contrast-10pct: hsla(214, 57%, 24%, 0.1);
        --lumo-contrast-20pct: hsla(214, 53%, 23%, 0.16);
        --lumo-contrast-30pct: hsla(214, 50%, 22%, 0.26);
        --lumo-contrast-40pct: hsla(214, 47%, 21%, 0.38);
        --lumo-contrast-50pct: hsla(214, 45%, 20%, 0.5);
        --lumo-contrast-60pct: hsla(214, 43%, 19%, 0.61);
        --lumo-contrast-70pct: hsla(214, 42%, 18%, 0.72);
        --lumo-contrast-80pct: hsla(214, 41%, 17%, 0.83)
        --lumo-contrast-90pct: hsla(214, 40%, 16%, 0.94);
        --lumo-contrast: hsl(214, 35%, 15%);

        --lumo-error-color-10pct: hsla(3, 100%, 60%, 0.1);
        --lumo-error-color-50pct: hsla(3, 100%, 60%, 0.5);
        --lumo-error-color: hsl(3, 100%, 61%);
        --lumo-error-contrast-color: #FFF;

        --lumo-success-color-10pct: hsla(145, 76%, 44%, 0.12);
        --lumo-success-color-50pct: hsla(145, 76%, 44%, 0.55);
        --lumo-success-color: hsl(145, 80%, 42%);
        --lumo-success-contrast-color: #FFF;

        --lumo-header-text-color: gray; #hsl(214, 35%, 15%);
        --lumo-body-text-color: hsla(214, 40%, 16%, 0.94);

        #        --lumo-primary-text-color: hsl(214, 90%, 52%);
        #        --lumo-primary-text-color: rgb(30, 159, 64);
        --lumo-primary-text-color: green;
        --lumo-secondary-text-color: hsla(214, 42%, 18%, 0.72);
        --lumo-tertiary-text-color: hsla(214, 45%, 20%, 0.5);
        --lumo-disabled-text-color: hsla(214, 50%, 22%, 0.26);
        --lumo-error-text-color: hsl(3, 92%, 53%);
        --lumo-success-text-color: hsl(145, 100%, 32%);

        --lumo-base-color: #FFF;
        --lumo-primary-color: rgb(30, 159, 64); #rgb(233,245,235);
        --lumo-primary-color-10pct: rgba(30, 159, 64, 0.1);
        --lumo-primary-color-50pct: rgba(30, 159, 64, 0.5);
        // --lumo-seconday-color: rgb(233,245,235);

        --lumo-link-color: var(--lumo-primary-text-color);



        --pro-logo-url: url('./img/logo_OPPLUS.png');
        --pro-header-color: rgb(232, 245, 236);

        --lumo-base-color: #FFFFFF;

        --lumo-font-family: 'ubuntu', "Ubuntu", "Roboto", "Segoe UI", Helvetica, Arial, sans-serif;
        --lumo-body-text-color: hsla(214, 40%, 16%, 0.94);
        --lumo-link-color: #009fff;

        --lumo-primary-color: rgb(39,158,131);
        --lumo-primary-color-10pct: rgba(39,158,131, 0.1);
        --lumo-primary-color-50pct: rgba(39,158,131, 0.5);
        --lumo-primary-contrast-color: #FFFFFF;
        --lumo-primary-text-color: rgb(30,84,132);

        --lumo-border-radius: 0.2em;
    }

    [theme~="opplus"] {

        --pro-logo-url: url('./img/logo_OPPLUS.png');
        --pro-header-color: rgb(232, 245, 236);

        --lumo-base-color: #FFFFFF;

        --lumo-font-family: "Montserrat", 'ubuntu', "Ubuntu", "Roboto", "Segoe UI", Helvetica, Arial, sans-serif;
        --lumo-body-text-color: hsla(214, 40%, 16%, 0.94);
        --lumo-link-color: #009fff;

        --lumo-primary-color: rgb(39,158,131);
        --lumo-primary-color-10pct: rgba(39,158,131, 0.1);
        --lumo-primary-color-50pct: rgba(39,158,131, 0.5);
        --lumo-primary-contrast-color: #FFFFFF;
        --lumo-primary-text-color: rgb(30,84,132);

        --lumo-border-radius: 0.2em;
    }

    [theme~="qipro"] {

        --pro-logo-url: url('./img/logo_QIPRO.png');
        --pro-header-color:  rgb(213,235,247);

        --lumo-base-color: #FFFFFF;

        --lumo-font-family: 'ubuntu', "Ubuntu", "Roboto", "Segoe UI", Helvetica, Arial, sans-serif;
        --lumo-body-text-color: hsla(214, 40%, 16%, 0.94);
        --lumo-link-color: var(--lumo-primary-text-color);

        --lumo-primary-color: rgb(240,132,64);
        --lumo-primary-color-10pct: rgba(89,140,178,0.1); #hsla(214, 90%, 52%, 0.1);
        --lumo-primary-color-50pct: rgba(234,249,250,0.5); #hsla(214, 90%, 52%, 0.5);
        --lumo-primary-contrast-color: #FFFFFF;
        --lumo-primary-text-color: rgb(33,112,155);

        --lumo-border-radius: 0.3em;
    }

    [theme~="bbva"] {

        --pro-logo-url: url('./img/logo_BBVA.png');
        --pro-header-color:  #ebf9fa;

        --lumo-font-family: 'ubuntu', "Ubuntu", "Roboto", "Segoe UI", Helvetica, Arial, sans-serif;

        --lumo-primary-text-color: #1d73b2;
        --lumo-body-text-color: hsla(214, 40%, 16%, 0.94);
        --lumo-error-text-color: hsl(3, 92%, 53%);
        --lumo-success-text-color: hsl(145, 100%, 32%);

        --lumo-link-color: var(--lumo-primary-text-color);

        --lumo-base-color: #FFFFFF;
        --lumo-primary-color: rgb(29,115,178);
        --lumo-primary-color-10pct: rgba(89,140,178,0.1); #hsla(214, 90%, 52%, 0.1);
        --lumo-primary-color-50pct: rgba(234,249,250,0.5); #hsla(214, 90%, 52%, 0.5);
        --lumo-primary-contrast-color: #FFFFFF;

        --lumo-border-radius: 0em;
    }


    .v-loading-indicator::after {
      content: "";
      position: fixed; /* Occupy whole screen even if scrolled */
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      /* Eat mouse events when visible, doesn't prevent scrolling */
      pointer-events: auto;
      /* Animated with delay to prevent flashing */
      animation: fadein 0.3s ease-out 0.2s normal 1 both;
      z-index: 2147483647;
      cursor: wait;
    }
    .v-loading-indicator[style*=none]::after {
        display: none;
    }

    @keyframes fadein {
      0% {
        background: rgba(0,0,0,0);
      }
      100% {
        background: rgba(0,0,0,.6); /* Darkens the UI */
      }
    }

  </style>
</custom-style>


<custom-style>
  <style>
    html {
      overflow:hidden;
      background: var(--lumo-contrast-10pct);
    }

    vaadin-app-layout vaadin-tab a:hover {
      text-decoration: none;
    }

    .column-spacing-small {
    	--vaadin-form-layout-column-spacing: 0.5em;
//    	margin-left: 5px;
//      margin-right: 5px;
    }

    .nota {
        margin-top: 1.5em;
     	font-size: var(--lumo-font-size-l);
    }

    .upper-case {
        text-transform: uppercase;
    }

  </style>
</custom-style>

<dom-module id="text-field-style" theme-for="vaadin-text-field">
  <template>
    <style>
        [part="input-field"] {
            box-shadow:inset 0 0 0 1px var(--lumo-contrast-30pct);
            background-color:var(--lumo-base-color);
        }

        :host([invalid]) [part="input-field"] {
            box-shadow:inset 0 0 0 1px var(--lumo-error-color);
        }
    </style>
  </template>
</dom-module>

<dom-module id="text-field-style" theme-for="vaadin-text-area">
  <template>
    <style>
    </style>
  </template>
</dom-module>

<dom-module id="chart" theme-for="vaadin-chart">
  <template>
    <style include="vaadin-chart-default-theme">
      :host {
        --vaadin-charts-color-0: var(--lumo-primary-color);
        --vaadin-charts-color-1: var(--lumo-error-color);
        --vaadin-charts-color-2: var(--lumo-success-color);
        --vaadin-charts-color-3: var(--lumo-contrast);
      }
      .highcharts-container {
        font-family: var(--lumo-font-family);
      }
      .highcharts-background {
        fill: var(--lumo-base-color);
      }
      .highcharts-title {
        fill: var(--lumo-header-text-color);
        font-size: var(--lumo-font-size-xl);
        font-weight: 600;
        line-height: var(--lumo-line-height-xs);
      }
      .highcharts-legend-item text {
        fill: var(--lumo-body-text-color);
      }
      .highcharts-axis-title,
      .highcharts-axis-labels {
        fill: var(--lumo-secondary-text-color);
      }
      .highcharts-axis-line,
      .highcharts-grid-line,
      .highcharts-tick {
        stroke: var(--lumo-contrast-10pct);
      }
      .highcharts-column-series rect.highcharts-point {
        stroke: var(--lumo-base-color);
      }
    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
