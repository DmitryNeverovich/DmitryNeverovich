<%-- 
    Document   : userPage
    Created on : 03.07.2014, 0:13:40
    Author     : Dima
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result work</title>
    </head>
    <body>
        <table border="1" align="center">
            <tr>
                <td>ID</td>
                <td>FAMILY</td>
                <td>NAME</td>
                <td>HIGHT</td>
                <td>SOIL</td>
                <td>ORIGIN</td>
                <td>MYLTIPLYING</td>
                <td>COLOR STALK</td>
                <td>COLOR LIST</td>
                <td>TEMPERATURE</td>
                <td>LIGHT</td>
                <td>WATER</td>
            </tr>
            <c:forEach var="flower" items="${flowers}">
                <tr>
                    <td>${flower.id}</td>
                    <td>${flower.family}</td>
                    <td>${flower.name}</td>
                    <td>${flower.hight}</td>
                    <td>${flower.soil}</td>
                    <td>${flower.origin}</td>
                    <td>${flower.myltiplying}</td>
                    <td>${flower.colorStalk}</td>
                    <td>${flower.colorList}</td>
                    <td>${flower.temperature}</td>
                    <td>${flower.light}</td>
                    <td>${flower.water}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
