

function lol(element){
var productId = $(element).attr("product-id");

 if (!productId) {
        alert('Product ID is missing!');
        return;
    }

    // Відправка POST-запиту на сервер
    $.post("basket", {'productId': productId}, function(data) {
        if (data === 'Success') {
            alert('Product added to bucket successfully!');
        } else {
            alert('Failed to add product to bucket.');
        }
    }).fail(function() {
        alert('Error while processing your request.');
    });
}