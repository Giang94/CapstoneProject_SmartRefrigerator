<%-- 
    Document   : parseSuccess
    Created on : Feb 12, 2016, 4:33:07 PM
    Author     : Dell
--%>

<%@page import="java.util.ListIterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="list" value="${requestScope.LIST}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            ListIterator<String> result = (ListIterator<String>) request.getAttribute("LIST");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Product</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    while (result.hasNext()) {
                        String value = result.next();
                        i++;
                %>
                <tr>
                    <td><%= (i + 1)%></td>
                    <td><%= value%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    <c:if test="${not empty list}">
        <c:out value="thien dept trai"/>
    </c:if>
</body>
</html>
