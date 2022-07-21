var msg = null;
function ValidateEmail(mail)
{
    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail))
    {
        return (true)
    }
    window.alert("You have entered an invalid email address!")
    return (false)
}
function register() {
    if ($('#username').val() == "") {
        window.alert("you need to fill all");
        return false;
    } else if ($('#password').val() == "") {
        window.alert("you need to fill all");
        return false;
    } else if ($('#email').val() != "") {

        if (!(ValidateEmail($('#email').val().toString()))) {

            return false;
        }

    }

    var data = $('#frm-register').serializeArray();
    $.ajax({
        type: 'POST',
        url: 'Register',
        data: data,
        dataType: 'JSON',
        error: function (e) {
            alert('Error: ' + e);
        },

        success: function (data) {

            msg = data[0].msg;
            if (msg == 1) {
                window.alert("Register success");
                window.location.reload();
            }
            if (msg == 2) {
                window.alert("Register fail, Please try another user name");
            }
        }

    });
}
;