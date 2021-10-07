<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" 
src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function update() {
	
	   $.ajax({
			url:"/update.do",
			type:"POST",
			data:$("#updateForm").serialize(),
			dataType:"JSON",
				
		  success: function (result) {
			   console.log(result);
			   alert("수정 성공!");
			   location.href="/list2.do";
			   
			}
					
	   })
}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  
     <h1>수정페이지</h1>
     
     <form id="updateForm">
     
      <table border="2" width="600">
      
      <tr>
         <td>번호</td>
         <td>제목</td>
         <td>작성자</td>
         <td>내용</td>
         <td>분류</td>
      
      </tr>
      
      <tr>
       <td>  <input type="text" name="bnum"  value="${board.bnum }"  /></td>
       <td>  <input type="text" name="title"  value="${board.title }"  /></td>
       <td>  <input type="text" name="writer"  value="${board.writer }"  /></td>
       <td>  <input type="text" name="bcontent"  value="${board.bcontent }"  /></td>
       <td>  <input type="text" name="btype"   value="${board.btype }"  /></td>
      </tr>
        
    
     </table>
     </form>
       <button  type="button" onclick="update()" >글수정 </button>  
     
</body>
</html>