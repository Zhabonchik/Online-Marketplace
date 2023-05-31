<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Торговая площадка</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp"%>
<form action="/marketplace/home" method="get">
    <main class="container my-5">
        <section class="my-5">
            <h1>Добро пожаловать на нашу торговую площадку!</h1>
            <p>Здесь вы можете найти множество товаров по доступным ценам.</p>
            <button class="btn btn-primary">Подробнее</button>
        </section>
        <section class="my-5">
            <h2>Новые поступления</h2>
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img class="card-img-top" src="${requestScope.Image1}" style="height: 50%; width:50%;"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${requestScope.Phone1.getName_()}</h5>
                            <a href="/marketplace/phone?phoneId=${requestScope.Phone1.getID_product_()}" class="btn btn-primary" >Купить</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img class="card-img-top" src="${requestScope.Image2}"style="height: 50%; width:50%;"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${requestScope.Phone2.getName_()}</h5>
                            <a href="/marketplace/phone?phoneId=${requestScope.Phone2.getID_product_()}&imageLink=${requestScope.Image2}" class="btn btn-primary" >Купить</a>                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img class="card-img-top" src="${requestScope.Image3}"style="height: 50%; width:50%;"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${requestScope.Phone3.getName_()}</h5>
                            <a href="/marketplace/phone?phoneId=${requestScope.Phone3.getID_product_()}&imageLink=${requestScope.Image3}" class="btn btn-primary" >Купить</a>                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="my-5">
            <h2>Выбор редакции</h2>
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img class="card-img-top" src="${requestScope.Image4}"style="height: 50%; width:50%;"
                             alt="Card image cap">>
                        <div class="card-body">
                            <h5 class="card-title">Товар 4</h5>
                            <a href="/marketplace/phone?phoneId=${requestScope.Phone4.getID_product_()}&imageLink=${requestScope.Image4}" class="btn btn-primary" >Купить</a>                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img class="card-img-top" src="${requestScope.Image5}"style="height: 50%; width:50%;"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Товар 5</h5>
                            <a href="/marketplace/phone?phoneId=${requestScope.Phone5.getID_product_()}&imageLink=${requestScope.Image5}" class="btn btn-primary" >Купить</a>                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img class="card-img-top" src="${requestScope.Image6}"style="height: 50%; width:50%;"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Товар 6</h5>
                            <a href="/marketplace/phone?phoneId=${requestScope.Phone6.getID_product_()}&imageLink=${requestScope.Image6}" class="btn btn-primary" >Купить</a>                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</form>
<footer class="bg-light py-3 mt-5">
    <div class="container text-center">
        <p>© Торговая площадка, 2023</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>