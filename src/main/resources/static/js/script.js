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
    // Headline 
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

    // Profile
    const addProfileBtn = $("#addProfileBtn");
    const cartProfile = $("#cartProfile");
    const closeProfile = $("#closeProfile");

    addProfileBtn.on("click", function () {
        cartProfile.toggleClass("visible");
    });

    closeProfile.on("click", function (e) {
        e.preventDefault();
        cartProfile.removeClass("visible");
    });
    // Education
    const addEducationBtn = $("#addEducationBtn");
    const cartEducation = $("#cartEducation");
    const closecart = $("#closecart");

    addEducationBtn.on("click", function () {
        cartEducation.toggleClass("visible");
    });

    closecart.on("click", function (e) {
        e.preventDefault();
        cartEducation.removeClass("visible");
    });
    // Experience
    const addExperienceBtn = $("#addExperienceBtn");
    const cartExperience = $("#cartExperience");
    const closeExperience = $("#closeExperience");

    addExperienceBtn.on("click", function () {
        cartExperience.toggleClass("visible");
    });

    closeExperience.on("click", function (e) {
        e.preventDefault();
        cartExperience.removeClass("visible");
    });
    // Key skills
    const addskillsBtn = $("#addskillsBtn");
    const cartskills = $("#cartskills");
    const closeskills = $("#closeskills");

    addskillsBtn.on("click", function () {
        cartskills.toggleClass("visible");
    });

    closeskills.on("click", function (e) {
        e.preventDefault();
        cartskills.removeClass("visible");
    });
    // Project
    const addProjectBtn = $("#addProjectBtn");
    const cartProject = $("#cartProject");
    const closeProject = $("#closeProject");

    addProjectBtn.on("click", function () {
        cartProject.toggleClass("visible");
    });

    closeProject.on("click", function (e) {
        e.preventDefault();
        cartProject.removeClass("visible");
    });
    // IT Skill
    const addITSkillBtn = $("#addITSkillBtn");
    const cartITSkill = $("#cartITSkill");
    const closeITSkill = $("#closeITSkill");

    addITSkillBtn.on("click", function () {
        cartITSkill.toggleClass("visible");
    });

    closeITSkill.on("click", function (e) {
        e.preventDefault();
        cartITSkill.removeClass("visible");
    });

});