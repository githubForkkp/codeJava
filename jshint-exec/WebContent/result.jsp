<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%
    request.setCharacterEncoding("gb2312");
%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>result</title>
<meta http-equiv=”pragma” content=”no-cache”>
<meta http-equiv=”cache-control” content=”no-cache”>
<meta http-equiv=”expires” content=”0”>
</head>
<body><h3>扫描结果：</h3>
</body>
<%
List result = (ArrayList)request.getAttribute("result");
for (int i=0;i<=result.size()-1;i++){%>
	<br><% out.print(result.get(i));%>
<%}%>

</html>