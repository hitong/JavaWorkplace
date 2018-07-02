<%@page import="been.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	if (request.getSession().getAttribute("adminId") == null) {
		response.sendRedirect("../JspServlet/AdminLogin.html");
	}
	int bookTotalPage = dao.Dao.getBookPage();
	int userTotalPage = dao.Dao.getUserPage();
	String w = request.getParameter("w");
	if(w == null){
	 	w = "choiseNull";
	 	}
	String flag = request.getParameter("flag");
	String flag2 = request.getParameter("flag2");
	String InputSearchUser = request.getParameter("InputSearchUser");
	String InputSearchBook = request.getParameter("InputSearchBook");
	String SearchType = request.getParameter("SearchType");
	String ChoiseType = request.getParameter("ChoiseType");
	if(ChoiseType == null){
		ChoiseType = "";
	}
	if(InputSearchUser == null){
		InputSearchUser = "";
	}
	if(SearchType == null){
		SearchType = "";
	}
	if(InputSearchBook == null){
		InputSearchBook = "";
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <title>Book Store 后台管理系统</title>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular-animate.min.js"></script>
    <script src = "shopManager.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet"  type="text/css"  href="./ManagerCss.css"/>
    
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"51977",secure:"51982"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4" data-genuitec-path="/JspServlet/WebRoot/Manager2.jsp">

<div class="top" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-4" data-genuitec-path="/JspServlet/WebRoot/Manager2.jsp">
	<form action = "servlet/Exit" method = "post">
			<input type = "submit"	 hidden id = "exit1" name = "exit"  value = <%= request.getSession().getAttribute("adminId") %>>
	</form>
    <span class="head">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Book Store</span>
    <span class = "exit">欢迎你，<%= request.getSession().getAttribute("adminId") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class = "a" href = "user.jsp">前台</a> | <a class = "a" id = "exit">退出</a>&nbsp;&nbsp;&nbsp;</span>
</div>

<div class="middle">
    <div class = "left">
        <div class = "nav" id = "user">用户管理</div>
        <div class = "nav" id = "shop">商品管理</div>
    </div>
    
    <form action = "Manager2.jsp" method = "post">
    	<input type = "hidden"  id = "InputSearchUser" name = "InputSearchUser">
    	<input type = "hidden"  id = "InputSearchBook" name = "InputSearchBook">
    	<input type = "hidden" id = "SearchType" name = "SearchType">
    	<input type = "hidden"  id = "ChoiseType" name = "ChoiseType">
    	<input type = "submit" id = "upSearch" hidden>
    </form>
    
    <div class = "right">
        <div class = "insert_shop"  <% if(w.compareTo("choiseBook") != 0 && ChoiseType.compareTo("book") != 0) out.print("hidden");%>>
            <div class = "searchBook">
                        <span class="input-group Myinput-group">
                            <span class="input-group-addon">书名: </span>
                            <input type="text" class="form-control"placeholder="请输入输入条件" id = "InputBook"
						value = <%=InputSearchBook %>>
					</span>
                <span class = "titile">
                            类型：
                        </span>
                <span class="btn-group">
                            <button type="button" class="btn btn-primary dropdown-toggle"
                                    data-toggle="dropdown"  id = "BookShow">
                                <%
                             	    if(SearchType.compareTo("")==0){
                             	    	out.print("所有类型  ▼");
                             	    }
                               		else{
                               			out.print(SearchType + "  ▼");
                               		}
                                %>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                         		<li><a href="#"  id = "BAll">所有类型</a></li>
                                <li><a href="#"   id = "BChild">儿童类</a></li>
                                <li><a href="#"  id = "BT">科技类</a></li>
                                <li><a href="#"  id = "BWar">军事类</a></li>
                                <li><a href="#"  id = "BNov">小说类</a></li>
                                <li><a href="#"  id = "BCom">计算机类</a></li>
                                <li><a href="#"  id = "BSin">化工类</a></li>
                                <li><a href="#"  id = "BOt">其他类</a></li>
                                
                                <li class="divider"></li>
                                <li><a href="#" id = "now">所有类型</a></li>
                            </ul>
                        </span>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-primary"  id = "SearchBook">搜索</button>
                </span>
                <button class="btn btn-primary add" data-toggle="modal" data-target="#myModal" id = "addBook">
                新增
                 </button>
            </div>
           
            <div>
					<%
						util.SplitPage sp = new util.SplitPage();
						if (flag == null || Integer.parseInt(flag) == 0) {
							flag = "1";
						};		
						int t = Integer.parseInt(flag);	
						if(t > bookTotalPage){
							t = bookTotalPage;
						}
						sp.setCurrentPage(t);
						int times1 = 0;	

						List<been.Book> list = new LinkedList<>();
						if(ChoiseType.compareTo("book") != 0 || InputSearchBook.compareTo("") ==0){
							  	list = dao.Dao.findAllBook(sp);
							}
						else{
							list  = dao.Dao.searchBook(InputSearchBook,SearchType);
						}
					%>

					<table class="table table-bordered table-hover">
               		<thead>
               			<tr>
               				<th class = "td1">ISBN</th>
               				<th class = "td2">书名</th>
               				<th class = "td3">作者</th>
               				<th class = "td4">价格</th>
               				<th class = "td5">出版社</th>
               				<th class = "td6">库存</th>
               				<th  class = "td7">类型</th>
               				<th  class = "td8">操作</th>
               			</tr>
               		</thead>
               		<tbody>
               		
					<% for(been.Book b: list) { %>
                    <% times1++;%>
                    <tr>
                    <input type = "hidden"  id = "img<%=times1%>"  value ="<%=b.getImg()%>">
                    <input type = "hidden"  id = "message<%=times1%>"  value = "<%= b.getMessage() %>">
					<td class = "td1" id ="isbn<%=times1 %>" ><%=b.getISBN() %></td>
					<td class = "td2" id = "bookname<%=times1%>"><%= b.getName()%></td>
					<td class = "td3" id = "editor<%=times1%>"><%=b.getEditor()%></td>
					<td class = "td4" id = "price<%=times1%>"><%= b.getPrice() %></td>
					<td class = "td5" id = "pub<%=times1%>"><%= b.getPub() %></td>
					<td class = "td6" id = "stock<%=times1%>"><%= b.getStock() %></td>
					<td class = "td7" id = "type<%=times1%>"><%=b.getType()%></td>
                    <td class = td8>
                    <span id = "2edit<%=times1 %>" data-toggle="modal" data-target="#myModal">编辑</span>
                    <span id = "2del <%=times1 %>">删除</span>
                    <span id = "2view<%=times1 %>" data-toggle="modal" data-target="#myModal">查看</span>
                    </td>
					</tr>
					<%} %>
					</tbody>
                </table>
            	
	                <input type = "button"   id = "bookDown"  value = "下一页" style = "float:right;margin-right:5%;">
	                <input type = "button"   id = "bookUp"  value = "上一页" style = "float:right;margin-right:0.3%;">
              
            </div>
        </div>
        <div class = "insert_user"  <% if(w.compareTo("choiseUser") != 0 && ChoiseType.compareTo("user") != 0) out.print("hidden");%>>
            <div class = "searchBook">
                        <span class="input-group Myinput-group">
                            <span class="input-group-addon">用户名: </span>
                            <input type="text" class="form-control" placeholder="请输入输入用户名"  id = "InputUser"
                            	<% if(ChoiseType.compareTo("user") == 0){
                            		   out.print("value  = " + InputSearchUser);
                            		}
                     			%>
                            >
                     </span>
                
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%
							util.SplitPage sp2 = new util.SplitPage();
							if (flag2 == null) {
								flag2 = "1";
							};				
							int t2 = Integer.parseInt(flag2);
							
							if(t2 > userTotalPage){
								t2= userTotalPage;
							}
							sp2.setCurrentPage(t2);
							sp2.setPageRows(10);
							List<been.User> list2 = new LinkedList<>();
						if(ChoiseType.compareTo("user") != 0 || InputSearchUser.compareTo("") ==0){
							  	list2 = dao.Dao.findAllUser(sp2);
							}
						else{
							list2  = dao.Dao.searchUser(InputSearchUser);
						}
						%>
						<button type="button" class="btn btn-primary"  id ="SearchUser" >搜索</button>
                        </span>
                <span>
                    <button type="button" class="btn btn-primary" style = "float:right" id = "add" data-toggle="modal" data-target="#myModal2">
                    增加</button>
                </span>

            </div>
            <div>
                 <table class="table table-bordered  table-striped table-hover">
               		<thead>
               			<tr>
               				<th class = "td1">用户名</th>
               				<th class = "td2">性别</th>
               				<th class = "td3">生日</th>
               				<th class = "td4">电话</th>
               				<th class = "td5">邮政编码</th>
               				<th class = "td6">地址</th>
               				<th  class = "td7">真实姓名</th>
               				<th  class = "td7">余额</th>
               				<th  class = "td8">操作</th>
               			</tr>
               		</thead>
               		<tbody>
               		<% int times = 0; 
               			 for(been.User b: list2) {
						 times++; 
					 %>
					<tr>
					<input type="hidden"  id ="password<%=times %>"   value="<%=b.getPassWord() %>"/>
					<td class = "td1"  id ="name<%=times %>" ><%=b.getName() %></td>			
					<td class = "td2"  id ="sex<%=times %>"><%=b.getSex() %></td>
					<td class = "td3" id ="birth<%=times %>" ><%=b.getBirth() %></td>			
					<td class = "td4" id ="tel<%=times %>"><%=b.getTel() %></td>
					<td class = "td5" id ="num<%=times %>"><%=b.getNum() %></td>
				   <td class ="td6" id ="ad<%=times %>"  ><%=b.getAd() %></td>
					<td class = "td7" id ="real<%=times %>" ><%= b.getRealName()%></td>
					<td class = "td7"  id ="monney<%=times %>" ><%=b.getMonney() %></td>
					<td class = td8>
						<span id = "edit<%=times%>" data-toggle="modal" data-target="#myModal2">编辑</span>
						<span id = "del <%=times%>">删除</span>
						<span id = "view<%=times%>" data-toggle="modal" data-target="#myModal2">查看</span>
					</td>
					</tr>
					<%} %>
					</tbody>
                </table>
                	<ul class="pagination pagination-lg" >
					<li><input type = "button" id = "userUp" value= "上一页"></li>
					<li><input type = "button"   id = "userDown"  value = "下一页"></li>
				 </ul>
            </div>
        </div>
    </div>
</div>
<div class="company"><i>copyright</i></div>
<input type = "hidden"  id = "w"  value = <%=w %> name = "w">
<input type = "hidden"  id = "flag"  value = <%=flag %>  name = "flag">
<input type = "hidden"  id = "flag2"  value = <%=flag2 %>  name = "flag2">
<input type = "hidden"  id = "bookTotalPage"  value = <%= bookTotalPage %>>
<input type = "hidden"  id = "userTotalPage"  value = <%= userTotalPage %>>
<a href = "Manager2.jsp"   id = "spMove" hidden>as</a>

<!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">新增图书</h4>
                    </div>
                    <form action="servlet/UpBook"  method="post" enctype="multipart/form-data">
                    <div class="modal-body" >
                        <div class="input-group">
                            <span class="input-group-addon">ISBN</span>
                            <input type="text" class="form-control"  name = "isbn" id = "isbn">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">书名</span>
                            <input type="text" class="form-control" name = "book" id = "book">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">作者</span>
                            <input type="text" class="form-control" name = "editor" id = "editor">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">价格</span>
                            <input type="text" class="form-control" name = "price" id = "price">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">出版社</span>
                            <input type="text" class="form-control" name = "pro" id = "pro"> 
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">简介</span>
                            <textarea rows = 5 class="form-control" style = "resize:none;" name = "message" id = "message"></textarea>
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">库存</span>
                            <input type="text" class="form-control"  name = "num" id = "stork">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">类型</span>
                            <input type="text" class="form-control"  name = "type" id = "type">
                        </div>
                        <br>
                        <img  id = "img" src = ""  width = 60px height = 60px >
                        <input type = "file" name = "file"  id = "file"  hidden>
                        <input type = "text" name = "bookOP" id = "bookOP"  hidden>
                        
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-primary" value = "添加" id = "bookSubmit">
                        <button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
                    </div>
                </form><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </div>
    <!-- /.modal -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel2" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel2">新增用户</h4>
				</div>
				<form action="servlet/AddUser" method="post" id = "userForm">
					<input type = "hidden" name = "upUserUrl" id = "upUserUrl">
					<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon">用户名</span> <input type="text"
								class="form-control" name="name" id = "userName">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">密码</span> <input type="text"
								class="form-control" name="password" id= "userPassword"> 
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">性别</span> <input type="text"
								class="form-control" name="sex" id = "userSex">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">生日</span> <input type="date"
								class="form-control" name="date" id = "userDate">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">电话</span> <input type="text"
								class="form-control" name="tel" id = "userTel">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">邮政编码</span> <input type="text"
								class="form-control" name="mailnum" id = "userNum">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">地址</span> <input type="text"
								class="form-control" name="ad" id = "userAd">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">真实姓名</span> <input type="text"
								class="form-control" name="realname" id = "realName">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">余额</span> <input type="text"
								class="form-control" name="yu" id = "userYu">
						</div>
						<br>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="添加" id = "userSubmit">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</form>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
	<!-- /.modal -->

	<form action = "servlet/Nav" method = "post">
	<input type = "hidden"  name = "myUrl"  id = "url"  value = ""/>
	<input type = "submit"  hidden name = "op"  id = "op"  value = ""/>
    </form>
</body>
</html>