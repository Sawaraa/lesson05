<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/admin.css">
     <script> src= "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"</script>
</head>
<body>
    <jsp:include page="adminHeader.jsp"></jsp:include>

    <div class="container mt-5">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-md-8">
                <form id="productForm" class="productForm" method="post">
                    <h1 id="register">Create Product</h1>

                    <input placeholder="Title..." type="text" class="title" id="title" name="title"></p>

                    <p><input placeholder="Description" type="text" class="description"  id="description" name="description"></p>

                    <p><input placeholder="Author" type="text" class="author" id="author" name="author"></p>

                    <p><input placeholder="Pages" type="text" class="pages" id="pages" name="pages"></p>

                    <p><input placeholder="Price" type="text" class="price" id="price" name="price"></p>

                    <button type="button" onclick="create()"><i class="fa fa-angle-double-right "></i>Create</button></div>
                </form>
            </div>
        </div>
    </div>

    <script src="js/adminProduct.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>