<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>个人中心</title>
	<link rel="stylesheet" type="text/css" href="../resources/home/css/bootstrap.min.css">
	<script type="text/javascript" src="../resources/home/js/jquery-2.1.4.min.js" ></script>
</head>
<body>
	
	<div style="text-align: center;border-bottom:1px solid #E9ECEF;">
	<h3>个人中心</h3>
	</div>
	
	<div class="wrap1000">
		<div class="clear" style="height:500px; ">
			<div style="float: left;width: 20%;padding: 10px;height:500px; border-right:1px solid #E9ECEF;" >
			 <ul style="list-style: none;">
			 	<li style="padding: 5px;"><a href="../index/index" >首页</a></li>
			 	<li style="padding: 5px;"><a href="../index/center" >我的信息</a></li>
			 	<li style="padding: 5px;"><a href="../index/collect" >我的收藏</a></li>
			 	<li style="padding: 5px;"><a href="../index/chgpass" >密码修改</a></li>
			 	<li style="padding: 5px;"><a href="../index/logout" >退出</a></li>
			 </ul>
			</div>
			
			<div style="float: right;width: 75%;padding: 10px;" >
				<dl>
					<dt>新密码</dt>
					<dd><input type="password" name="user" class="text" id="p1"/></dd>
				</dl>
				<dl>
					<dt>密码确认</dt>
					<dd><input type="password" name="user" class="text" id="p2"/></dd>
				</dl>
									<dl>
					<dt>&nbsp;</dt>
					<dd><input type="button" id="chg-submit" value="保  存" /></dd>
				</dl>
			</div>
		
		
		</div>
		
	</div>
	
	<div style="text-align: center; border-top:1px solid #E9ECEF;">
		<p> <a href="../index/index">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> | <a href="">联系我们</a></p>
		<p>Copyright 2019-2020 智慧消费新闻 Inc.,All rights reserved.</p>
	</div>
</body>
<script>

	$("#chg-submit").click(function(){
		if ( $("#p1").val() == ''){
			alert("请输入新密码");
			return false;
		}
		if ( $("#p2").val() == ''){
			alert("请输入密码确认");
			return false;
		}
		if ( $("#p1").val() != $("#p2").val()){
			alert("密码不一致");
			return false;
		}
		
		if( confirm("确定要保存吗？")){
			$.ajax({
				url:'../index/savepass',
				type:'POST',
				data:{password:$("#p1").val()},
				dataType:'json',
				success:function(data){
					if(data.type == 'success'){
						window.location.reload();
					}else{
						alert(data.msg);
					}
				}
			});
		}
		
	});
</script>
</html>
