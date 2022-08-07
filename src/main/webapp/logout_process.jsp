<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
%>
<!DOCTYPE html>
<html id="home" lang="ko">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그아웃 처리</title>
        <style type="text/css">
        </style>
    </head>
    <body>
    <script type="text/javascript">
    document.location.href = '${pageContext.request.contextPath}/';
    </script>
    </body>
</html>