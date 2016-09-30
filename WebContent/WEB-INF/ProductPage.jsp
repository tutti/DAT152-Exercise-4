<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="coffee-tags" prefix="cof" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="/Exercise_4_-_h145157/style/main.css" />
        <fmt:setBundle basename="bundles.CoffeeShop" var="messages" scope="session"/>
        <title><fmt:message key="products" bundle="${messages}" /></title>
    </head>
    <body>
        <c:forEach items="${locales}" var="locale">
        <a href="?lang=${locale.getLanguage()}_${locale.getCountry()}">${locale.getDisplayLanguage(locale)}</a>
        </c:forEach>

        <h1><fmt:message key="products" bundle="${messages}" /></h1>
        <form action="/Exercise_4_-_h145157/products" method="post">
            <c:forEach items="${products.getObjects()}" var="product">
            <div class="product">
                <h3>${product.pname}</h3>
                <div class="product-left">
                    <img src="/Exercise_4_-_h145157/${product.imageURL}" /><br>
                </div>
                <div class="product-right">
                    <span><fmt:message key="name" bundle="${messages}" />: ${product.pname}</span><br />
                    <span><fmt:message key="price" bundle="${messages}" />: <fmt:formatNumber type="currency" value="${entry.getKey().price}" /></span><br />
                    <span><fmt:message key="description" bundle="${messages}" />: ${product.description.text}</span><br />
                    <button name="pno" value="${product.pno}"><fmt:message key="addToCart" bundle="${messages}" /></button>
                </div>
            </div>
            <div class="clearfloat"></div>
            </c:forEach>
        </form>
        <p>
            <a href="/Exercise_4_-_h145157/home"><fmt:message key="home" bundle="${messages}" /></a>
            <a href="/Exercise_4_-_h145157/cart"><fmt:message key="cart" bundle="${messages}" /></a>
        </p>
        <em><cof:copyright since="2008">HiB</cof:copyright></em>
    </body>
</html>