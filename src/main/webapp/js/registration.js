function ready(){
 event.preventDefault();
	var firstName = $('#typeFirstName').val();
	var lastName = $("#typeLastName").val();
	var email = $("#typeEmailX").val();
	var password = $("#typePasswordX").val();

	if (firstName == '' || lastName == '' || email == '' || password == '') {
		alert("Please fill all fields...!!!!!!");
	} else if ((password.length) < 4) {
		alert("Password should at least 4 character in length...!!!!!!");
	}else {
		var userRegistration = {
			firstName : firstName,
			lastName : lastName,
			email : email,
			password: password
			};
		$.post("registration", userRegistration,
         function(data) {
         	if (data == 'Success') {
         		$("form")[0].reset();
         		$("form")[1].reset();
         	}
         });
	}
};

function login(){
    var email = $("#typeEmailX").val();
	var password = $("#typePasswordX").val();
	if (email == '' || password == '') {
		alert("Please fill login form!");
	} else {
		var userLogin = {
			email : email,
			password : password
		};

		$.post("login", userLogin, function(data) {
			console.log(data);
			if (data.success) {
                            // Після успішного логування, отримаємо роль
                            $.get("user-role", function(roleData) {
                                if (roleData !== '') {
                                    var userRole = roleData;  // Роль користувача
                                    console.log("User role:", userRole);
                                    // Можна зберегти роль у sessionStorage для подальшого використання
                                    sessionStorage.setItem("userRole", userRole);

                                }
                            });
		});
	}
};

