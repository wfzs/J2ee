<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
你好  JSP
<br>
<%=new Date().toLocaleString() %>
<br>

page:<%=page%>
<br>
this:<%=this%>

<jsp:include page="footer.jsp">
	<jsp:param name="year" value="2019" />
</jsp:include> 
<%--<%@include file="footer.jsp" %>--%>