$(document).on({
    ajaxStart: function () {
        $(document.body).addClass('loading');
    },
    ajaxStop: function () {
        $(document.body).removeClass('loading');
    }
});
