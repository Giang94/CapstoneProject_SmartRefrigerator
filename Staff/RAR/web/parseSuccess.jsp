<%-- 
    Document   : parseSuccess
    Created on : Feb 12, 2016, 4:33:07 PM
    Author     : Dell
--%>

<%@page import="sample.pojo.content"%>
<%@page import="java.util.List"%>
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
            List<content> tmp = (List<content>) request.getAttribute("LIST");
            ListIterator<content> result = null;
            if (tmp != null) {
                result = tmp.listIterator();
            }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Type</th>
                    <th>Content</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    while (result.hasNext()) {
                        content value = result.next();
                        if (!value.getValue().equals("")) {
                            i++;
                %>
            <form action="insertServlet">
                <tr>
                    <td><%= i%></td>
                    <td><%= value.getKey()%> 
                    </td>
                    <td><input type="text" name="<%= value.getKey()%>" value="<%= value.getValue()%>" size="90"/></td>
                </tr>
                <%
                        }
                    }
                %>
                <input type="submit" value="INSERT" />
            </form>
        </tbody>
    </table>

    <c:if test="${empty list}">
        <c:out value="EMPTY LIST"/>
    </c:if>
</body>
</html>
