var timeRemind = setInterval(function () {

    var time = parseInt($('#timeR').val());


    var distance = time;
    document.getElementById('timeR').value = (parseInt($('#timeR').val()) - 1);
    // Time calculations for days, hours, minutes and seconds

    var minutes = Math.floor((distance % (60 * 60)) / (60));
    var seconds = Math.floor((distance % (60)));

    // Output the result in an element with id="demo"
    document.getElementById("timeDisplay").innerHTML = minutes + ":" + seconds;

    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(timeRemind);
        let form = document.getElementById('quest');

        form.method = 'POST';
        form.submit();
        document.getElementById("timeDisplay").innerHTML = "EXPIRED";
    }
}, 1000);
var nextQuestion = function () {

    document.getElementById('qesIndex').value = (parseInt($('#qesIndex').val()) + 1);

    document.submit();
}
