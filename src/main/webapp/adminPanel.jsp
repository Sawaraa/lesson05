<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <section>
        <div class="adminPanel">
        <h2 class="title" >Make Magazine</h2>
            <form class="forms" action="${pageContext.request.contextPath}/adminPanel" method="post">
            <label for="title">Enter title magazine</label>
            <br>
            <input class="uk-input" name="title">
            <br>
            <label for="description">Enter description</label>
            <br>
            <input class="uk-input" name="description">
            <br>
            <label for="author">Enter author</label>
            <br>
            <input class="uk-input" name="author">
            <br>
            <label for="pages">Enter pages</label>
            <br>
            <input class="uk-input" name="pages" />
            <br>
            <label for="price">Enter price</label>
            <br>
            <input class="uk-input" name="price" />
            <br>
            <input class="submit" type="submit" name="Submit">
        </form>
        </div>
    </section>

<c:if test="${not empty message}">
    <div class="uk-alert-success" uk-alert>
        <a class="uk-alert-close" uk-close></a>
        ${message}
    </div>
</c:if>
    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>