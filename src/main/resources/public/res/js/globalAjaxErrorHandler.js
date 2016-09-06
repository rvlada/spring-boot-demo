$(document).on({
    ajaxError: function (event, jqxhr) {
        var message = "status: " + jqxhr.status + ", responseText: " + jqxhr.responseText + ", statusText: " + jqxhr.statusText;
        $("#errorMessage").text(message);
        $("#errorModal").modal('show');
    }
});
