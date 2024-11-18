function create(){
 event.preventDefault();
	var title = $('#title').val();
	var description = $("#description").val();
	var author = $("#author").val();
	var pages = $("#pages").val();
	var price = $("#price").val();

	var product = {
    			title : title,
    			description : description,
    			author : author,
    			pages : pages,
    			price : price
    			};

    		$.post("adminPanel", product,
             function(data) {
             	if (data == 'Success') {
             		$("#productForm")[0].reset();
                    $("#message").text("Продукт успішно створено!").show();
             	}
             });
};