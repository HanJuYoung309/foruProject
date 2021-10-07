<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" 
src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

   function insert() {
	
	   $.ajax({
			url:"/insertProcess.do",
			enctype: 'multipart/form-data',
			processData:false, 
			contentType:false,
			type:"POST",
			cache: false,
		    timeout: 600000,
			data:$("#insertForm").serialize(),
			dataType:"JSON",
				
		  success: function (result) {
			   console.log(result);
			   alert("글입력 성공!");
			   location.href="/list2.do";
			   
			}
					
	   })
   }

</script>
<title>Insert title here</title>
</head>
<body>
    <h1>글 추가 PAGE</h1>
	    
	    <form id="insertForm" enctype="multipart/form-data">
	   
	   글번호: <input type="text" name="bnum" value="${max}" />	<br>
	   제목: <input type="text" name="title" /><br>
	   작성자: <input type="text" name="writer"/><br>
	   내용:  <textarea rows="20" cols="30" name="bcontent"></textarea><br>
	   분류: <input type="text" name="btype" /><br>  
	   파일첨부:<input type="file" name="file" />
	 
	    </form>
	   
  <button  type="button" onclick="insert()" >글입력</button>  
    
</body>
</html>