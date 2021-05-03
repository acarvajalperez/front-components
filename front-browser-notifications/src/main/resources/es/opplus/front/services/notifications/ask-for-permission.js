function dispatchEventWithDetail(eventDetail) {
    var customEvent = new CustomEvent("askUserForPermissionReport", {detail: eventDetail});
    $0.dispatchEvent(customEvent);
}

if(window.Notification) {

    function callback(result) {
        var customEvent = new CustomEvent("askUserForPermissionReport", {detail: result});
        $0.dispatchEvent(customEvent)
    }

    var permissionPromise = window.Notification.requestPermission(callback);

    if(permissionPromise) {
        permissionPromise.then(callback)
    }
}
else {
    var detail = "unsupported";
    dispatchEventWithDetail(detail);
}
