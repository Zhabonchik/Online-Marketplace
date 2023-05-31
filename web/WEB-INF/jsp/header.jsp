<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/marketplace/home">Торговая площадка</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/marketplace/home">Главная<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Товары</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">О нас</a>
                </li>
                <c:if test="${sessionScope.user == null and sessionScope.vendor == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/marketplace/login">Вход</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.user != null or sessionScope.vendor != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/marketplace/logout">Выход</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>
