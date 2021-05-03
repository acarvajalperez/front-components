var isSupported = false;
if (window.Notification) {
    isSupported = true;
}
var event = new CustomEvent('notificationsSupportReport', { detail: isSupported });
$0.dispatchEvent(event);
