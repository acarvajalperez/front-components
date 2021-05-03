var permission = "none"; //in case Notifications are not supported

if(window.Notification) {
    permission = window.Notification.permission;
}

var event = new CustomEvent('notificationsPermissionLevelReport', { detail: permission });
$0.dispatchEvent(event);