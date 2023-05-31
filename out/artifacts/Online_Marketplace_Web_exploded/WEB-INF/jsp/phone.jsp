<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Информация о телефоне</title>
  <!-- Подключение Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
  <!-- Подключение стилей -->
  <style type="text/css">
    .phone-info {
      margin-top: 50px;
      margin-bottom: 50px
    }

    .phone-img {
      max-width: 100%;
      height: auto;
      margin-bottom: 20px
    }

    .phone-heading {
      font-size: 24px;
      margin-bottom: 20px
    }

    .phone-description {
      margin-bottom: 20px
    }

    .phone-specs {
      margin-bottom: 20px
    }

    .phone-review {
      margin-bottom: 20px
    }
  </style>
</head>
<%@include file="header.jsp"%>
<body>
<div class="container">
  <div class="row phone-info">
    <div class="col-md-4 text-center">
      <img class="phone-img" src="${requestScope.ImageToDisplay}"
      alt="Card image cap"><br>
      <a href="/marketplace/review?phoneId=${requestScope.PhoneToDisplay.getID_product_()}" class="btn btn-primary" >Добавить отзыв</a>
    </div>
    <div class="col-md-8">
      <h2 class="phone-heading">${requestScope.PhoneToDisplay.getName_()}</h2>
      <p class="phone-description">${requestScope.PhoneToDisplay.getDescription_()}</p>
      <div class="phone-specs">
        <p><strong>Производитель:</strong> ${requestScope.PhoneToDisplay.getManufacturer_()}</p>
        <p><strong>Оперативная память:</strong> ${requestScope.PhoneToDisplay.getRAM_()} Гб</p>
        <p><strong>Постоянная память:</strong> ${requestScope.PhoneToDisplay.getROM_()} Гб</p>
        <p><strong>Операционная система:</strong> ${requestScope.PhoneToDisplay.getOperational_system_()}</p>
        <p><strong>Диагональ экрана:</strong> ${requestScope.PhoneToDisplay.getScreen_diagonal_()} дюймов</p>
        <p><strong>Разрешение экрана:</strong> ${requestScope.PhoneToDisplay.getScreen_resolution_()} пикселей</p>
        <p><strong>Разрешение камеры:</strong> ${requestScope.PhoneToDisplay.getCamera_megapixels_()} мегапикселей</p>
        <p><strong>Емкость батареи:</strong> ${requestScope.PhoneToDisplay.getBattery_capacity_()} мАч</p>
        <p><strong>Длина:</strong> ${requestScope.PhoneToDisplay.getLength_()} мм</p>
        <p><strong>Толщина:</strong> ${requestScope.PhoneToDisplay.getThickness_()} мм</p>
        <p><strong>Ширина:</strong> ${requestScope.PhoneToDisplay.getWidth_()} мм</p>
        <p><strong>Вес:</strong> ${requestScope.PhoneToDisplay.getWeight_()} г</p>
      </div>
      <div class="phone-review">
        <h4>Отзывы</h4>
        <c:forEach var="review" items="${requestScope.ReviewsToDisplay}">
          <div>
            <p>id пользователя: ${review.getID_user_()}</p><br>
            <p>${review.getReview_()}</p>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>

<!-- Подключение JavaScript файлов -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>