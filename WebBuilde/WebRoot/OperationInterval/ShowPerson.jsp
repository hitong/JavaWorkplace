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

    <title>My JSP 'MyJsp.jsp' starting page</title>

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
    <table>
      <tr>
    <th>PersonId</th>
		<th>PersonName</th>
        <th>Birthday</th>
        <th>Sex</th>
      </tr>
      <%
        dbService.PersonService personService = dbService.PersonService.getInstanse();
		ArrayList<Person> arrayList = personService.queryPerson("select * from person");
      %>
      <% for(int i = 0;i < arrayList.size(); i++){ %>
      <%="<tr>" %>
        <%= "<td>"%>
          <%= arrayList.get(i).getPersonId() %>
        <%=  "</td>"%>
        <%=  "<td>"%>
          <%= arrayList.get(i).getPersonName() %>
        <%=  "</td>"%>
        <%=  "<td>"%>
          <%= arrayList.get(i).getBirthday() %>
        <%=  "</td>"%>
        <%=  "<td>"%>
          <%= (arrayList.get(i).getSex() == 0) ?"男":"女"%>
        <%=  "</td>"%>
      <%="</tr>" %>
      <% } %>
    </table>
    <a href="OperationInterval/AddPerson.jsp">添加</a>
    <a href="OperationInterval/DelPerson.jsp">删除</a>
    <a href="OperationInterval/SearchPerson.jsp">查找</a>
  </body>
</html>

