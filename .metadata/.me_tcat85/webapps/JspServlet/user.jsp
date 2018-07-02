<%@page import="been.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <link rel = "stylesheet" type="text/css" href = "./StyleSheet.css" />
    <title>学生信息管理系统</title>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular-animate.min.js"></script>
    <script src="js.js"></script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"51977",secure:"51982"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-11" data-genuitec-path="/JspServlet/WebRoot/user.jsp">
    <div class="top" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-11" data-genuitec-path="/JspServlet/WebRoot/user.jsp">
        <div class = "head_Concent">
            <span class = "head">Book Store</span>
            <span class = "login">
            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"
            	<% if(request.getSession().getAttribute("user") == null) {%>
            	<% out.print( "hidden"); %>
            >
                        登录
                    </button>
            </span>
            <span class = "login">
                <form action = "servlet/LogOn" method = "post">
                    <input type = "submit"  <% out.print( "hidden"); %> name = "logOn" value = "注册" class="btn btn-primary btn-lg">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </form>
            </span>
            <% }else{%>
            
             </div>
             <% out.print(((been.User)(request.getSession().getAttribute("user") )).getName());}%>
    </div>

    <div class = "middle">
        <div class = "concent">
            <div class = "menu">  		
	                <div class = "pagination">
	                   	<li><a href="user.jsp?choise=全部分类">全部分类</a></li>
	                    <li><a href="user.jsp?choise=儿童类">儿童类</a></li>
	                    <li><a href="user.jsp?choise=科技类">科技类</a></li>
	                    <li><a href="user.jsp?choise=军事类">军事类</a></li>
	                    <li><a href="user.jsp?choise=小说类">小说类</a></li>
	                    <li><a href="user.jsp?choise=计算机类">计算机类</a></li>
	                    <li><a href="user.jsp?choise=化工类">化工类</a></li>
	                    <li><a href="user.jsp?choise=其他类">其他类</a></li>
	                </div>
            </div>
            <div class = "book">
				<%
					String choise = request.getParameter("choise");
					util.SplitPage s = (util.SplitPage) request.getSession()
							.getAttribute("stest");
					util.SplitPage sp = new util.SplitPage(6);
					String flag = request.getParameter("flag");
					if (flag == null) {
						flag = "1";
					};
					int t = Integer.parseInt(flag);
					sp.setCurrentPage(t);
					if (choise == null) {
						choise = "全部分类";
					}
				    List<been.Book> list = dao.Dao.findAllBook(choise, sp);
				%>
				<table class="table table-bordered">
					<%
						int times = 0;
						for (been.Book b : list) {
							if (times++ % 3 == 0) {
								out.print("<tr>");
							}
							out.print("<td class = \"td1\">"
									+ "<img height = 260 width = 330  src = '" + b.getImg()
									+ "'>");
							out.print("<br>" + b.getName() + "     $" + b.getPrice()
									+ "</td>");
						}
						if (times % 3 == 0) {
						out.print("</tr>");
						}
					%>
				</table>
			</div>
            <div class = "number pagination" >
            	<li><a href="user.jsp?flag=<% out.print(--t);++t;%>">上一页</a></li>
				<li><a href="user.jsp?flag=<% out.print(++t);%>">下一页</a></li>
            </div>
        </div>
    </div>

    <div class = "company"><i>copyright</i></div>

    <form action = "servlet/Login" method = "post">
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-hidden="true">×
                        </button>
                        <h3 class="modal-title" id="myModalLabel" align="center"><i>
                           登录
                        </i></h3>
                    </div>
                    <div class="modal-body" align="center">
                        <div class="input-group">
							<input type="text" class="form-control" placeholder="用户名" name="username" > 
						</div>
						<br>
						<div class="input-group">
							<input type="password" placeholder="密码" class="form-control" name="password" > 
						</div>
						<br>                 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">关闭
                        </button>
                        <input type="submit" value = "确定" class="btn btn-primary">
           		     </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </form>
   
</body>
</html>