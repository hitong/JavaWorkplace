<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'Caculator.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>

  <body  ng-app="">
    <div>
        <input type="number" id = "firstNum">
          <select id ="choise">
            <option value ="+">+</option>
            <option value ="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
          </select>
        <input type="number" id = "secondNum">
        <button onclick="caculator()">  =  </button>
        <label id = "reslut"></label>

    </div>
  </body>
  <script type="text/javascript">
    function caculator(){
      var  myselect=document.getElementById("choise");
      var index = myselect.selectedIndex;
      var choise = myselect.options[index].value;
      var tmp = 0;

      switch (choise) {
        case "+":tmp = document.getElementById("firstNum").value * 1 +
                        document.getElementById("secondNum").value * 1;
                        break;
        case "-":tmp = document.getElementById("firstNum").value-
                        document.getElementById("secondNum").value;
                        break;
        case "*":tmp = document.getElementById("firstNum").value*
                        document.getElementById("secondNum").value;
                        break;
        case "/":tmp = document.getElementById("firstNum").value /
                        document.getElementById("secondNum").value;
                        break;
      }
      document.getElementById("reslut").innerHTML=tmp;
    }
  </script>
</html>
