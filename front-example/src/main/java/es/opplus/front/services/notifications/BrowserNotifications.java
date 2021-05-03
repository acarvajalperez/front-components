package es.opplus.front.services.notifications;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.DomListenerRegistration;
import elemental.json.JsonValue;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class BrowserNotifications {

    private final static String showNotificationJS = loadJS("show-notification");
    private final static String showNotificationWithBodyJS = loadJS("show-notification-with-body");
    private final UI myUI;

    private BrowserNotifications(UI myUI) {
        this.myUI = myUI;
    }

    private static String loadJS(String jsFileName) {
        InputStream resourceAsStream = BrowserNotifications.class.getResourceAsStream(jsFileName + ".js");
        try {
            return IOUtils.toString(resourceAsStream, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BrowserNotifications extend(UI ui) {
        Objects.requireNonNull(ui, "UI can't be null");
        return new BrowserNotifications(ui);
    }

    private static PermissionLevel convertToPermissionLevel(JsonValue jsonValue) {
        return PermissionLevel.valueOf(jsonValue.asString().toUpperCase());
    }

    public void queryIfSupported(Consumer<Boolean> callback) {
        setupTest(callback, "test-support", "notificationsSupportReport", JsonValue::asBoolean);
    }

    public void queryPermissionLevel(Consumer<PermissionLevel> callback) {
        setupTest(callback, "test-permission-level", "notificationsPermissionLevelReport",
            PermissionLevel::valueOf);
    }

    private <T> void setupTest(Consumer<T> callback, String jsFileName, String eventName,
        Function<JsonValue, T> converterFromJsonValue) {
        String testJavaScript = loadJS(jsFileName);
        ReportListener<T> listener = new ReportListener<>(callback, converterFromJsonValue);
        DomListenerRegistration registration = myUI.getElement()
            .addEventListener(eventName, listener);
        listener.setRegistration(registration);
        registration.addEventData("event.detail");
        myUI.getPage().executeJavaScript(testJavaScript, myUI.getElement());
    }

    public void askForPermission(Consumer<PermissionLevel> callback) {
        setupTest(callback, "ask-for-permission", "askUserForPermissionReport",
            jsonValue -> PermissionLevel.valueOf(jsonValue.asString().toUpperCase()));
    }

    public CompletableFuture<Boolean> queryIfSupported() {
        return setupTestAsynch(this::queryIfSupported);
    }

   public CompletableFuture<PermissionLevel> queryPermissionLevel() {
        return setupTestAsynch(this::queryPermissionLevel);
   }
    public CompletableFuture<PermissionLevel> askForPermission() {
        return setupTestAsynch(this::askForPermission);
    }

    private <T> CompletableFuture<T> setupTestAsynch(Consumer<Consumer<T>> test) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        test.accept(testResult -> completableFuture.complete(testResult));
        return completableFuture;
    }

    public void showNotification(String title) {
        myUI.getPage().executeJavaScript(showNotificationJS, title);
    }

    public void showNotificationWithBody(String title, String body, String icon) {
        myUI.getPage().executeJavaScript(showNotificationWithBodyJS, title, body, icon);
    }

    public enum PermissionLevel {
        UNSUPPORTED, GRANTED, DENIED, DEFAULT;

        private static PermissionLevel valueOf(JsonValue jsonValue) {
            return valueOf(jsonValue.asString().toUpperCase());
        }
    }

    private class ReportListener<T> implements DomEventListener {
        private DomListenerRegistration registration;
        private Consumer<T> callback;
        private Function<JsonValue, T> converterFromJson;

        public ReportListener(Consumer<T> callback, Function<JsonValue, T> converterFromJson) {
            this.callback = callback;
            this.converterFromJson = converterFromJson;
        }

        @Override public void handleEvent(DomEvent event) {
            JsonValue eventDetail = event.getEventData().get("event.detail");
            callback.accept(converterFromJson.apply(eventDetail));
            registration.remove();
        }

        public void setRegistration(DomListenerRegistration registration) {

            this.registration = registration;
        }
    }
}
