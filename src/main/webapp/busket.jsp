<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
     <link rel="stylesheet" href="css/magazine.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

<div class="col-lg-4">
    <div class="card card-margin">
        <div class="card-header no-border">
            <h2 class="card-title">${product.title}</h2>
        </div>
        <div class="card-body pt-0">
            <div class="widget-49">
                <div class="widget-49-title-wrapper">
                    <div class="widget-49-date-primary">
                        <span class="widget-49-date-day">${product.price}</span>
                    </div>
                    <div class="widget-49-meeting-info">
                        <span class="widget-49-pro-title">${product.author}</span>
                        <span class="widget-49-meeting-time">${product.pages} pg</span>
                    </div>
                </div>
                <p class="widget-49-meeting-points">
                    ${product.description}
                </p>
                <div class="widget-49-meeting-action">
                    <a href="#" product-id="${product.id}" onclick="lol(this)" class="btn btn-sm btn-flash-border-primary buy-product">Buy</a>
                </div>
            </div>
        </div>
    </div>
</div>


    <script src="js/basket.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>