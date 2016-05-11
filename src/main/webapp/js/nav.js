// Base Navigation.
$(document).ready(function() {
    var pathname = window.location.pathname;
    $("#nav li").each(function() {
        if (pathname === "/admin-tool/settings.html") {
            if ($(this).text() ===  "Settings") {
                $("#nav li").each(function(){
                    $(this).removeClass("active");
                });
                $(this).addClass("active");
            }
        }
    });
});
