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
        <title><fmt:message key="home" bundle="${messages}" /></title>
    </head>
    <body>
        <c:forEach items="${locales}" var="locale">
        <a href="?lang=${locale.getLanguage()}_${locale.getCountry()}">${locale.getDisplayLanguage(locale)}</a>
        </c:forEach>
        
        <h1>Kaffekopper AS</h1>
        <h2><fmt:message key="home" bundle="${messages}" /></h2>
        <img src="/Exercise_4_-_h145157/images/logo.png" /><br />
        <fmt:message key="upsell" bundle="${messages}">
            <fmt:param><a href="/Exercise_4_-_h145157/products"><fmt:message key="products" bundle="${messages}" /></a></fmt:param>
        </fmt:message>
    </body>
</html>