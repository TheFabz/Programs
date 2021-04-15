

$(document).ready(function () {

        $("input").keyup(function () {
            var value = $(this).val();

            $("button").on("click", function () {

            $.get("https://api.github.com/search/users?q=" + value, function (data) {

                for (var i = 0; i < data.items.length; i++) {

                    $(".container").append('<div class="card" style="width: 18rem;">' +
                        '<img src="' + data.items[i].avatar_url + '" class="card-img-top" alt="...">' +
                        '<div class="card-body">' +
                        "<a href=" + "'" + data.items[i].html_url + "'" + "class='card-text'>" + data.items[i].login + "</a>" +

                        '</div>' +
                        '</div>' + "<br>");
                }
            });
        })
     
    })
});

