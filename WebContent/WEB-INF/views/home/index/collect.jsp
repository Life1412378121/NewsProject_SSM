<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				  <c:forEach items="${newsList }" var="news">
				  <article class="excerpt excerpt-1" style="">
						<header>
							<h4><a href="../news/detail?id=${news.id }" title="${news.title }" target="_blank" >${news.title }</a>
							&nbsp;&nbsp;<a href="javascript:;" class="del" coid="${news.id }" style="color:red;font-size: 14px;">[删除]</a></h4>
						</header>
						<p class="meta">
							<time class="time"><i class="glyphicon glyphicon-time"></i> <fmt:formatDate value="${news.createTime }" pattern="yyyy-MM-dd hh:mm:ss" /></time>
							<span class="views"><i class="glyphicon glyphicon-eye-open"></i> ${news.viewNumber }</span> 
							<a class="comment" href="../news/detail?id=${news.id }#comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i>${news.commentNumber }</a>
						</p>
						<p class="note">${news.abstrs }</p>
					</article>
					</c:forEach>
			</div>
		
		
		</div>
		
	</div>
	
	<div style="text-align: center; border-top:1px solid #E9ECEF;">
		<p> <a href="../index/index">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> | <a href="">联系我们</a></p>
		<p>Copyright 2019-2020 智慧消费新闻 Inc.,All rights reserved.</p>
	</div>

</body>
<script>

	$(".del").click(function(){
		if( confirm("确定要删除吗？")){
			var coid = $(this).attr("coid");
			$.ajax({
				url:'../index/delCollect',
				type:'POST',
				data:{newsId:coid},
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
