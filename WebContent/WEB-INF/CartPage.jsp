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
        <title><fmt:message key="cart" bundle="${messages}" /></title>
    </head>
    <body>
        <c:forEach items="${locales}" var="locale">
        <a href="?lang=${locale.getLanguage()}_${locale.getCountry()}">${locale.getDisplayLanguage(locale)}</a>
        </c:forEach>

        <h1><fmt:message key="cart" bundle="${messages}" /></h1>
        <table>
            <tr>
                <th><fmt:message key="name" bundle="${messages}" /></th>
                <th><fmt:message key="description" bundle="${messages}" /></th>
                <th><fmt:message key="price" bundle="${messages}" /></th>
                <th><fmt:message key="quantity" bundle="${messages}" /></th>
                <th><fmt:message key="total" bundle="${messages}" /></th>
            </tr>
            <c:forEach items="${cart.getEntryList()}" var="entry">
            <tr>
                <td>${entry.getKey().pname}</td>
                <td>${entry.getKey().description.text}</td>
                <td>${entry.getKey().priceInEuro}</td>
                <td>${entry.getValue()}</td>
                <td>TBD</td>
            </tr>

            </c:forEach>
        </table>
    </body>
</html>