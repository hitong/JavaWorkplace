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
    
    <title>My JSP 'DelResult.jsp' starting page</title>
    
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
    	String id = (String)request.getSession().getAttribute("delId");
    	PersonService personService = PersonService.getInstanse();
    	Person person = personService.searchPerson(id);
    	if(person == null){
    		out.print("你想要删除的人员不存在");
    	} else {
    		if(personService.deletePerson(person)){
    			out.print("删除成功");
    		} else {
    			out.print("删除失败");
    		}
    	}
    %>
    <a href = "OperationInterval/ShowPerson.jsp">返回</a>
  </body>
</html>
