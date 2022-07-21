var msg = null;
function makeQuiz() {


    var data = $('#makeQuiz').serializeArray();
    
    $.ajax({
        type: 'POST',
        url: 'MakeQuiz',
        data: data,
        dataType: 'JSON',
        error: function (e) {
            alert('Error: ' + e);
        },

        success: function (data) {

            msg = data[0].msg;
            if (msg == 1) {
                
                window.alert("Success");
                window.location.replace("MakeQuiz");

            }
            if (msg == 2) {
               
                window.alert("Some thing wrong, please try again");
                window.location.replace("MakeQuiz");
            }
        }

    });

}
;

