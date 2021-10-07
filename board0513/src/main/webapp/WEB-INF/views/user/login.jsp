<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<title>Home</title>
		<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").on("click", function(){
			alert("로그아웃!");
			location.href="logout.do";
		})
		
		
	})
	
	$(document).ready(function(){
	
		$("#logoinBtn").on("click", function(){
			alert("로그인 성공!");
		
			location.href="list.do";
		})
		
		
	})
	
	$(document).ready(function(){
	
		$("#joinBtn").on("click", function(){
			alert("회원가입페이지 이동!");
			location.href="register";
		})
		
	})
	
	 function submitCheck() {
            var userId  = $('#userId' ).val() ;
            var userPwd = $('#userPass').val() ;
            $.ajax({
                type :"POST",
                url: 'login.do',
                data: {userId:userId, userPwd:userPass},
                success: function(data) {
                    if(data == "false")
                        alert('잘못된 아이디이거나, 비밀번호가 틀렸습니다.') ;
                    else
                    	alert("회원님 환영합니다!");
                        location.href="list.do" ; 
                }
            }) ;
        }
	
	
	
</script>
<body>
    <h1>로그인</h1>
	<form name='homeForm' method="post">
		<c:if test="${member == null}">
			<div>
				<label for="userId"></label>
			아이디:	<input type="text" id="userId" name="userid">
			</div>
			<div>
				<label for="userPass"></label>
			비밀번호:	<input type="password" id="userPass" name="userPass">
			</div>
			<div>
				<button type="submit" id="logoinBtn">로그인</button>
				<button type="button" id="joinBtn">회원가입</button>
			</div>
		</c:if>
		
	</form>
</body>
</html>