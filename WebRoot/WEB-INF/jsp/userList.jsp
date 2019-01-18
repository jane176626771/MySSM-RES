<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>

	<script type="text/javascript">
		/* 采用javascript方式提交请求。通过hidden方式提交id值
		function del(){
			document.forms[0].action = "user/delete.do";
			document.forms[0].method = "post";
			document.forms[0].submit();
		} */
		
		//采用jquery方式提交请求
		function del(id){
			$.get("user/delUser.do?id="+id,function(data){
				if("success" == data.result){
					alert("删除成功");
					window.location.reload();
				}else{
					alert("删除失败");
				}
			});
		}
	</script>
  </head>
  
  <body>
    <a href="user/preAdd.do">添加用户</a>
    <form action="" id="listform">
    <table border="1">
    	<tbody>
    		<tr>
    			<th>姓名</th>
    			<th>密码</th>
    			<th>操作</th>
    		</tr>
    		<c:if test="${!empty userList}">
    			<c:forEach var="user" items="${userList}">
    				<tr>
    					<td>${user.name}</td>
    					<td>${user.password}</td>
    					<td>
    						<a href="user/preUpdate.do?id=${user.id}">修改</a>
    						<a href="javascript:del('${user.id }')">删除</a>
    						<input type="hidden" value="${user.id}" name="id">
    					</td>
    				</tr>
    			</c:forEach>
    		</c:if>
    	</tbody>
    </table>
    </form>
  </body>
</html>
