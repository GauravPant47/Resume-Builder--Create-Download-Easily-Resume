$(document).ready(function () {
    // TODO: it is help us to create a animation effext
    function toggleText() {
        $('.container h1').fadeOut(3000, function () {
            $(this).fadeIn(3000);
        })
    };
    setInterval(toggleText, 3000);
    toggleText();


    //TODO: here we can create a Slick slider
    $('.container .slider').slick({
        autoplay: true,
        autoplaySpeed: 3000,
        dots: true,
        arrows: true
    });
});