 var msg = null;
            function login() {
                if ($('#username').val() == "") {
                    window.alert("you need to fill all");
                    return false;
                } else if ($('#password').val() == "") {
                    window.alert("you need to fill all");
                    return false;
                }

                var data = $('#frm-login').serializeArray();
                $.ajax({
                    type: 'POST',
                    url: 'HomePage',
                    data: data,
                    dataType: 'JSON',
                    error: function (e) {
                        alert('Error: ' + e);
                    },

                    success: function (data) {

                        msg = data[0].msg;
                        if (msg == 1) {
                            window.location.replace("HomePage");
                        }
                        if (msg == 2) {
                            window.alert("please check your name or pass");
                        }
                    }

                });
            };