<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Magazines</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="magazine">
        <section>
            <h2 class="title">Available Magazines</h2>
            <div class="uk-grid uk-child-width-1-3@s uk-grid-match" uk-grid>
                <c:forEach var="magazine" items="${magazines}">
                    <div>
                        <div class="uk-card uk-card-default uk-card-body">
                            <h3 class="uk-card-title">${magazine.title}</h3>
                            <p><strong>Description:</strong> ${magazine.description}</p>
                            <p><strong>Author:</strong> ${magazine.author}</p>
                            <p><strong>Pages:</strong> ${magazine.pages}</p>
                            <p><strong>Price:</strong> $${magazine.price}</p>

                            <!-- Кнопка Buy, видима лише для авторизованих користувачів -->
                            <c:if test="${not empty sessionScope.loggedInUser}">
                                <form action="addToCart" method="post">
                                    <input type="hidden" name="title" value="${magazine.title}">
                                    <input type="hidden" name="price" value="${magazine.price}">
                                    <button type="submit" class="uk-button uk-button-primary">Buy!</button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>

        <!-- Блок для відображення куплених товарів -->
        <section>
            <div class="uk-grid uk-child-width-1-3@s uk-grid-match" uk-grid>
                <c:forEach var="cartItem" items="${sessionScope.cart}">
                <form action="deleteFromCart" method="post">
                    <div>
                        <div class="uk-card uk-card-secondary uk-card-body">
                            <input type="hidden" name="title" value="${cartItem.title}" />
                            <p><strong>Price:</strong> $${cartItem.price}</p>
                            <button type="submit" class="uk-button uk-button-primary">Remove!</button>
                        </div>
                    </div>
                </form>
                </c:forEach>
            </div>
            <!-- Відображення загальної суми -->
            <c:forEach var="cartItem" items="${sessionScope.cart}">
            <h3>Total: $<c:out value="${sessionScope.totalPrice}" /></h3>
             </c:forEach>
        </section>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>
