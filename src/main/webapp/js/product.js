
//$(document).ready(function () {
//    // Змінна для зберігання кількості товарів
//    let cartCount = 0;
//
//    // Додаємо подію на всі кнопки "Buy"
//    $(document).on('click', '.btn-flash-border-primary', function (event) {
//        event.preventDefault(); // Забороняємо стандартну поведінку кнопки
//
//        // Збільшуємо кількість товарів
//        cartCount++;
//
//        // Оновлюємо відображення числа у кошику
//        $(".cart_count span").text(cartCount);
//    });
//});


var products = null;

// Отримуємо продукти
$.get("products", function(data) {
    if (data !== '') {
        products = data; // Зберігаємо отримані продукти
    }
}).done(function() {
    // Контейнер для відображення продуктів
    var productContainer = $("#productContainer");

    // Додаємо кожен продукт до контейнера
    products.forEach(function(product) {
        var productHTML =
            "<div class='col-lg-4'>" +
                "<div class='card card-margin'>" +
                    "<div class='card-header no-border'>" +
                        "<h2 class='card-title'>" + product.title + "</h2>" +
                    "</div>" +
                    "<div class='card-body pt-0'>" +
                        "<div class='widget-49'>" +
                            "<div class='widget-49-title-wrapper'>" +
                                "<div class='widget-49-date-primary'>" +
                                    "<span class='widget-49-date-day'>" + product.price  + "$</span>" +
                                "</div>" +
                                "<div class='widget-49-meeting-info'>" +
                                    "<span class='widget-49-pro-title'>" + product.author + "</span>" +
                                    "<span class='widget-49-meeting-time'>" + product.pages + " pg</span>" +
                                "</div>" +
                            "</div>" +
                            "<p class='widget-49-meeting-points'>" +
                                product.description +
                            "</p>" +
                            "<div class='widget-49-meeting-action'>" +
                                "<a href='product?id=" + product.id + "' class='btn btn-sm btn-flash-border-primary'>Buy</a>" +
                            "</div>" +
                        "</div>" +
                    "</div>" +
                "</div>" +
            "</div>";
        productContainer.append(productHTML); // Додаємо HTML до контейнера
    });
});
