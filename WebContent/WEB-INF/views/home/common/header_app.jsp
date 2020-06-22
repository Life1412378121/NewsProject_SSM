<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>智慧消防新闻网站${title }</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="../resources/home/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../resources/home/css/nprogress.css">
<link rel="stylesheet" type="text/css" href="../resources/home/css/style.css">
<link rel="stylesheet" type="text/css" href="../resources/home/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="../resources/home/images/icon.png">
<link rel="shortcut icon" href="../resources/home/images/favicon.ico">
<script src="../resources/home/js/jquery-2.1.4.min.js"></script>
<script src="../resources/home/js/nprogress.js"></script>
<script src="../resources/home/js/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
  <script src="../resources/home/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="../resources/home/js/html5shiv.min.js" type="text/javascript"></script>
  <script src="../resources/home/js/respond.min.js" type="text/javascript"></script>
  <script src="../resources/home/js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<script>
function addFavorite(url, title) {
	try {
		window.external.addFavorite(url, title);
	} catch (e){
		try {
			window.sidebar.addPanel(title, url, '');
        	} catch (e) {
			alert("请按 Ctrl+D 键添加到收藏夹", 'notice');
		}
	}
}

</script>
</head>
<body class="user-select">
</body>