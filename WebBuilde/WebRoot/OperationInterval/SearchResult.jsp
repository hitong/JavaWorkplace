<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="db.*" %>
<%@ page import="dbService.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SearchResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	String id = (String)request.getSession().getAttribute("searchId");
    	PersonService personService = PersonService.getInstanse();
    	Person person = personService.searchPerson(id);
    	if(person == null){
    		out.print("暂未查询到你要的人员信息");
    	} else {
    		out.print("PersonId: " + person.getPersonId() + "<br/>");
    		out.print("PersonName: " + person.getPersonName() + "<br/>");
    		out.print("Birthday: " + person.getBirthday() + "<br/>");
    		out.print("Sex: " + (person.getSex() == 1 ? "男" : "女")+ "<br/>");
    	}
    %>
    <a href = "OperationInterval/ShowPerson.jsp">返回</a>
  </body>
</html>
