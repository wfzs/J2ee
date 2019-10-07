<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	application.setAttribute("test", 1);
    application.setAttribute("test2", 2);
    application.setAttribute("test", 3);
    application.removeAttribute("test");
%>