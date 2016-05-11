$(document).ready(function() {
    $('#search').validate({// initialize the plugin
        rules: {
            moduleCode: {
                required: true,
                minlength: 3,
                maxlength: 7
            }
        }
    });

    for (var i = new Date().getFullYear() + 5; i > 2010; i--) {
        $('#year').append($('<option />').val("" + (i - 2000)).html(i));
    }
    $("select option").filter(function() {
        return $(this).val() == (new Date().getFullYear() - 2000);
    }).attr('selected', true);
});