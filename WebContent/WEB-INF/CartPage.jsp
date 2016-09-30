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
        <table id="carttable">
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
                <td><cof:shorttext maxchars="25">${entry.getKey().description.text}</cof:shorttext></td>
                <td><fmt:formatNumber type="currency" value="${entry.getKey().price}" /></td>
                <td>${entry.getValue()}</td>
                <td><fmt:formatNumber type="currency" value="${entry.getKey().price * entry.getValue()}" /></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="4"><fmt:message key="totalamount" bundle="${messages}" />:</td>
                <td><fmt:formatNumber type="currency" value="${total}" /></td>
            </tr>
        </table>
        <p>
            <a href="/Exercise_4_-_h145157/home"><fmt:message key="home" bundle="${messages}" /></a>
            <a href="/Exercise_4_-_h145157/products"><fmt:message key="products" bundle="${messages}" /></a>
        </p>
        <em><cof:copyright since="2008">HiB</cof:copyright></em>
    </body>
</html>