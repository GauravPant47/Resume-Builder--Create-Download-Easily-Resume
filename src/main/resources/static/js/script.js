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
    // TODO: Profile Drop Down Menu
    var isHovered = false;

    $(".profile-dropdown").click(function () {
        $(this).find(".profile-content").toggle();
    });

    // $(".profile-dropdown").hover(function () {
    //     isHovered = true;
    //     $(this).find(".profile-content").show();
    // }, function () {
    //     isHovered = false;
    //     $(this).find(".profile-content").hide();
    // });

    $(document).click(function (event) {
        var target = $(event.target);
        if (!target.closest(".profile-dropdown").length && !isHovered && $(".profile-content").is(":visible")) {
            $(".profile-content").hide();
        }
    });

    const addHeadlineBtn = $("#addHeadlineBtn");
    const cart = $("#cart");
    const closeBtn = $("#closeBtn");

    addHeadlineBtn.on("click", function () {
        cart.toggleClass("visible");
    });

    closeBtn.on("click", function (e) {
        e.preventDefault();
        cart.removeClass("visible");
    });

});