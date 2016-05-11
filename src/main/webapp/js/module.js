$(document).ready(function() {
    $("#toolCountError").hide();
    $("#createClient").submit(function(event) {
        if($(":checkbox[name='createTool']:checked").length > 0){
            $("#toolCountError").hide();
            return;
        }

        $("#toolCountError").show();
        event.preventDefault();
    });

});