<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-3" data-genuitec-path="/JspServlet/WebRoot/Manager.jsp">
    <div class="top" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-3" data-genuitec-path="/JspServlet/WebRoot/Manager.jsp">
        <span class="head">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Book Store</span>
        <span class = "exit"><a class = "a">前台</a> | <a class = "a">退出</a>&nbsp;&nbsp;&nbsp;</span>
    </div>

    <div class="middle">
        <div class = "left">
            <div class = "nav" id = "user">用户管理</div>
            <div class = "nav" id = "shop">商品管理</div>
        </div>
        <div class = "right">
              <div class = "insert_shop" hidden>
                    <div class = "searchBook">
                        <span class="input-group">
                            <span class="input-group-addon">书名: </span>
                            <input type="text" class="form-control" placeholder="请输入输入条件">
                        </span>
                        <span class = "titile">
                            类型：
                        </span>
                        <span class="btn-group">
                            <button type="button" class="btn btn-primary dropdown-toggle"
                                    data-toggle="dropdown">
                                所有类型
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">功能</a></li>
                                <li><a href="#">另一个功能</a></li>
                                <li><a href="#">其他</a></li>
                                <li class="divider"></li>
                                <li><a href="#">分离的链接</a></li>
                            </ul>
                        </span>
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-primary">搜索</button>
                        </span>
                    </div>
                <div class = "add">
                    <button type="button" class="btn btn-primary" style = "float:right" id = "add">新增</button>
                </div>
                <div>
                    <table>

                    </table>
                </div>
              </div>
            <div class = "insert_user" hidden>
                <div class = "searchBook">
                        <span class="input-group">
                            <span class="input-group-addon">书名: </span>
                            <input type="text" class="form-control" placeholder="请输入输入条件">
                        </span>
                    <span class = "titile">
                            类型：
                        </span>
                    <span class="btn-group">
                            <button type="button" class="btn btn-primary dropdown-toggle"
                                    data-toggle="dropdown">
                                所有类型
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">功能</a></li>
                                <li><a href="#">另一个功能</a></li>
                                <li><a href="#">其他</a></li>
                                <li class="divider"></li>
                                <li><a href="#">分离的链接</a></li>
                            </ul>
                        </span>
                    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-primary">搜索</button>
                        </span>
                </div>
                <div class = "add">
                    <button type="button" class="btn btn-primary" style = "float:right" id = "add">新增</button>
                </div>
                <div>
                    <table>

                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="company"><i>copyright</i></div>
    <div class = "model" hidden>
        <center>
            <form class = "addForm"  action="servlet/UpBook"  method="post" enctype="multipart/form-data">
                <table cellspacing="50px" cellpadding="30px" style="border-collapse:separate;border-spacing:10px;">
                    <caption >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入如下信息</caption>
                    <tbody>
                        <tr>
                            <td>ISBN:</td>
                            <td class = "in"><input type = "text" size="35" name = "ISBN"></td>
                        </tr>
                        <tr >
                            <td>书名：</td>
                            <td class = "in"><input type = "text" size="35" name = "name"></td>
                        </tr>
                        <tr >
                            <td>作者：</td>
                            <td class = "in"><input type = "text" size="35" name = "editor"></td>
                        </tr>
                        <tr >
                            <td>价格：</td>
                            <td class = "in"><input type = "text" size="35" name = "price"></td>
                        </tr>
                        <tr >
                            <td>图片展示：</td>
                            <td colspan="2"><input type = "file" name = "img" accept="image/*" width="10px" name = "123" size = "35"></td>
                        </tr>
                        <tr >
                            <td>出版社：</td>
                            <td class = "in"><input type = "text" name = "compony" size="35"></td>
                        </tr>
                        <tr >
                            <td>图书详情：</td>
                            <td class = "in">
                                <textarea rows=3   name=s1   cols=35 name = "message"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>库存：</td>
                            <td class = "in"><input type = "text" size="35" name = "num"></td>
                        </tr>
                        <tr >
                            <td>类型：</td>
                            <td class = "in"><input type = "text" size="35" name = "type"></td>
                        </tr>
                    </tbody>
                </table>
                <hr>
                <input type="submit" class="btn btn-default btn-lg" id = "ok" value = "确定"></input>
                <button type="button" class="btn btn-default btn-lg" id = "cancel">取消</button>
            </form>
        </center>
    </div>
</body>
</html>