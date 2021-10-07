<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" 
src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function deletePro() {
	
	   $.ajax({
			url:"/delete.do",
			type:"POST",
			data:$("#deleteForm").serialize(),
			dataType:"JSON",
				
		  success: function (result) {
			   console.log(result);
			   alert("삭제  성공!");
			   location.href="/list2.do";
			   
			}
					
	   })
}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
     <h1>삭제페이지</h1>
     
     <form id="deleteForm">
     
     <input type="hidden" name="bnum" value="${board.bnum }" />
     <p> ${board.title }을 정말 삭제하시겠습니까?</p>
     </form>
      <button  type="button" onclick="deletePro()" >글삭제 </button>  
</body>
</html>