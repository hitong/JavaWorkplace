
$(document).ready(function(){
    $("p").click(function(){
        $(this).fadeOut();
    });
    
    $("#exit").click(function(){
    	$("#exit1").trigger('click');
    });
    
    $("#SearchUser").click(function(){
    	$("#InputSearchUser").val($("#InputUser").val());
    	$("#ChoiseType").val("user");
    	$("#upSearch").trigger('click');
    });
    
    $("#SearchBook").click(function(){
    	$("#InputSearchBook").val($("#InputBook").val());
    	$("#ChoiseType").val("book");
    	$("#upSearch").trigger('click');
    });
    
    $("#BAll").click(function(){
    	$("#now").text("所有类型");
    	$("#SearchType").val("");
    	$("#BookShow").text("所有类型  ▼");
    });
    
    $("#BT").click(function(){
    	$("#now").text("科技类");
    	$("#SearchType").val("科技类");
    	$("#BookShow").text("科技类  ▼");
    });
    $("#BChild").click(function(){
    	$("#now").text("儿童类");
    	$("#SearchType").val("儿童类");
    	$("#BookShow").text("儿童类  ▼");
    });
    $("#BWar").click(function(){
    	$("#now").text("军事类");
    	$("#SearchType").val("军事类");
    	$("#BookShow").text("军事类  ▼");
    });
    $("#BNov").click(function(){
    	$("#now").text("小说类");
    	$("#SearchType").val("小说类");
    	$("#BookShow").text("小说类  ▼");
    });
    $("#BCom").click(function(){
    	$("#now").text("计算机类");
    	$("#SearchType").val("计算机类");
    	$("#BookShow").text("计算机类  ▼");
    });
    $("#BSin").click(function(){
    	$("#now").text("化工类");
    	$("#SearchType").val("化工类");
    	$("#BookShow").text("化工类  ▼");
    });
    $("#BOt").click(function(){
    	$("#now").text("其他类");
    	$("#SearchType").val("其他类");
    	$("#BookShow").text("其他类  ▼");
    });

    $("#shop").click(function () {
        $("div.insert_shop").toggle();
        $("div.insert_user").toggle(false);
        if($("#w").val() != "choiseBook"){
        	$("#w").val("choiseBook");
        }
        else{
        	$("#w").val("choiseNull");
        }
    });

    $("#user").click(function () {
        $("div.insert_shop").toggle(false);
        $("div.insert_user").toggle();
        if($("#w").val() != "choiseUser"){
        	$("#w").val("choiseUser");
        }
        else{
        	$("#w").val("choiseNull");
        }
    });
    
    $("#userUp").click(function(){
    	var tmp = $("#flag2").val();
    	$("#w").val("choiseUser");
    	if(tmp == "1"){
    		alert("已经是第一页了");
    	}
    	else{
    		$("#flag2").val(parseInt(tmp) - 1);
    		setUrl();
    		$('#spMove')[0].click();
    	}	
    });
    
    $("#userDown").click(function(){
    	$("#w").val("choiseUser");
    	var tmp = $("#flag2").val();
    	if(tmp >= $("#userTotalPage").val()){
    		alert("已经是最后一页了");
    	}
    	else{
    		$("#flag2").val(parseInt(tmp) + 1);
    		setUrl();
    		$('#spMove')[0].click();
    	};
    });
    
    $("#bookUp").click(function(){
    	$("#w").val("choiseBook");
    	var tmp = $("#flag").val();
    	if(tmp == "1"){
    		alert("已经是第一页了");
    	}
    	else{
    		$("#flag").val(parseInt(tmp) - 1);
    		setUrl();
    		$('#spMove')[0].click();
    	}	
    });
    
    $("#bookDown").click(function(){
    	$("#w").val("choiseBook");
    	var tmp = $("#flag").val();
    	if(tmp >= $("#bookTotalPage").val()){
    		alert("已经是最后一页了");
    		$("#flag").val($("#bookTotalPage").val());
    	}
    	else{
    		$("#flag").val(parseInt(tmp) + 1);
    		setUrl();
    		$('#spMove')[0].click();
    	};
    });
    
    var setUrl = function(){
    	$("#spMove").attr("href","http://localhost:8080/JspServlet/Manager2.jsp?w=" + $("#w").val() + "&flag=" + $("#flag").val() + "&" +
    			"flag2=" + $("#flag2").val());
    };
    
    $("#addBook").click(function(){
    	$("#myModalLabel").text("新增图书");
    	setFormForBook(9999,false);
		$("#img").hide();
		setUrl();
		$("#file").show();
		$("#bookOP").val("upBook" + $("#spMove").attr('href'));
		$("#bookSubmit").show();
    });
    
    $("#add").click(function () {
		$("#myModalLabel2").text("新增用户");
		setFormForUser(9999,false);
         $("#userDate").attr('readonly', false);
	     $("#userForm").attr('action', 'servlet/AddUser');
	     setUrl();
	     $("#upUserUrl").val($("#spMove").attr('href'));
	     $("#userSubmit").show();
    });
    
 	$("#searchUser").click(function(){
 		 alert($("#real2").val());
 	});	 
 	
 	$("#img").click(function(){
 		if($("#bookOP").val() != "no"){
 			$("#file").trigger('click');
 		}
 	});
 	
 	$("span").click(function(){
 		var id = $(this).attr("id");
 		var num = id.substring(5);
 		var op = id.substring(0,5);
 		setUrl();
 		if (op == "2edit") {
			$("#myModalLabel").text("修改图书信息");
			setFormForBook(num, false);
			$("#bookForm").attr('action', 'servlet/UpdateBook');
			$("#upBookUrl").val($("#spMove").attr('href'));
			$("#img").show();
			$("#img").attr('src', $("#img" + num).val());
			$("#file").hide();
			$("#isbn").attr('readonly',true);
			$("#bookOP").val("cgBook" + $("#spMove").attr('href'));
			$("#bookSubmit").show();
		}
 		else if (op == "2del ") {
			if (confirm("请确认删除")) {
				$("#url").val($("#spMove").attr('href'));
				$("#op").val("2del " + $("#isbn" + num).text());
				$("#op").trigger('click');
			}
		}	
 		else if(op == "2view"){
 			$("#myModalLabel").text("查看图书信息");
			setFormForBook(num, true);
			$("#bookForm").attr('action', 'servlet/UpdateBook');
			$("#img").attr('src', $("#img" + num).val());
			$("#img").show();
			$("#bookOP").val("no");
			$("#file").hide();
			$("#upBookUrl").val($("#spMove").attr('href'));
			$("#bookSubmit").hide();
 		}
 		else{
 			op = id.substring(0,4);
 			num = id.substring(4);
 			if(op == "del "){
 	 			if(confirm("请确认删除")){ 
 	 				$("#url").val($("#spMove").attr('href'));
 	 				$("#op").val("del " + $("#name" + num).text());
 	 				$("#op").trigger('click');
 	 		    }
 	 		}
 	 		else if(op == "view"){
 	 		    $("#myModalLabel2").text("查看用户信息");
 	 		    setFormForUser(num,true);
 				$("#url").val($("#spMove").attr('href'));
 				$("#userSubmit").hide();
 	 		}
 	 		else if(op == "edit"){
 	 			 $("#myModalLabel2").text("修改用户信息");
 	 			 setFormForUser(num,false);
				$("#userName").attr('readonly', true);
				$("#userForm").attr('action', 'servlet/UpdateUser');
				setUrl();
				$("#upUserUrl").val($("#spMove").attr('href'));
				$("#userSubmit").show();
 	 		}
 		}
 	});
 	
 	$(".insert_user").click(function(){
 		
 	});
 	
 	var 	setFormForUser = function(num,f){
 			$("#userName").val($("#name" + num).text());
			$("#userPassword").val($("#password" + num).val());
			$("#userSex").val($("#sex" + num).text());
			$("#userDate").val($("#birth" + num).text());
			$("#userTel").val($("#tel" + num).text());
			$("#userNum").val($("#num" + num).text());
			$("#userAd").val($("#ad" + num).text());
			$("#realName").val($("#real" + num).text());
			$("#userYu").val($("#monney" + num).text());
			$("#userName").attr('readonly',f);
			$("#userPassword").attr('readonly',f);
			$("#userSex").attr('readonly',f);
			$("#userDate").attr('readonly',f);
			$("#userTel").attr('readonly',f);
			$("#userNum").attr('readonly',f);
			$("#userAd").attr('readonly',f);
			$("#realName").attr('readonly',f);
			$("#userYu").attr('readonly',f);
			$("#img").attr('src', $("#img" + num).val());
 		};
 		
 	 	var setFormForBook = function(num,f){
 	 		$("#isbn").val($("#isbn" + num).text());
			$("#book").val($("#bookname" + num).text());
			$("#editor").val($("#editor" + num).text());
			$("#price").val($("#price" + num).text());
			$("#pro").val($("#pub" + num).text());
			$("#message").val($("#message" + num).val());
			$("#stork").val($("#stock" + num).text());
			$("#type").val($("#type" + num).text());
			$("#img").val($("#img" + num).val());
			$("#isbn").attr('readonly',f);
			$("#book").attr('readonly',f);
			$("#editor").attr('readonly',f);
			$("#price").attr('readonly',f);
			$("#pro").attr('readonly',f);
			$("#message").attr('readonly',f);
			$("#stork").attr('readonly',f);
			$("#type").attr('readonly',f);
 		};
});