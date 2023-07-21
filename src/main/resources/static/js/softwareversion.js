$(document).ready(function () {
    $("#software").on("change", function () {
        var selectedSoftware = $(this).val();
        var versionsSelect = $("#versions");

        var javaVersions = ["Java 8", "Java 9", "Java 10", "Java 11", "Java 12", "Java 13", "Java 14", "Java 15", "Java 16"];
        var javascriptVersions = ["ES5", "ES6 (ES2015)", "ES7 (ES2016)", "ES8 (ES2017)", "ES9 (ES2018)", "ES10 (ES2019)", "ES11 (ES2020)", "ES12 (ES2021)"];
        var mysqlVersions = ["MySQL 5.0", "MySQL 5.1", "MySQL 5.5", "MySQL 5.6", "MySQL 5.7", "MySQL 8.0"];
        var htmlVersions = ["HTML 4.01", "HTML5"];
        var phpVersions = ["PHP 5.6", "PHP 7.0", "PHP 7.1", "PHP 7.2", "PHP 7.3", "PHP 7.4", "PHP 8.0"];
        var pythonVersions = ["Python 2.7", "Python 3.0", "Python 3.1", "Python 3.2", "Python 3.3", "Python 3.4", "Python 3.5", "Python 3.6", "Python 3.7", "Python 3.8", "Python 3.9", "Python 3.10"];

        var versions;

        switch (selectedSoftware) {
            case "java":
                versions = javaVersions;
                break;
            case "javascript":
                versions = javascriptVersions;
                break;
            case "mysql":
                versions = mysqlVersions;
                break;
            case "html":
                versions = htmlVersions;
                break;
            case "php":
                versions = phpVersions;
                break;
            case "python":
                versions = pythonVersions;
                break;
            default:
                versions = [];
        }

        versionsSelect.empty(); // Clear previous versions
        for (var i = 0; i < versions.length; i++) {
            versionsSelect.append($("<option></option>").val(versions[i]).text(versions[i]));
        }
    });
});