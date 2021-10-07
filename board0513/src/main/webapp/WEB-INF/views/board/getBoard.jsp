<%@page import="org.springframework.web.context.request.AbstractRequestAttributesScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" 
src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$(document).ready( function () {
	
	$("#updateBtn").on("click", function () {
		 var bnum=$("#bnum").val();
		 alert("수정페이지이동");
		 location.href="/update.do?bnum="+bnum;
	})
	
	
	$("#deleteBtn").on("click", function () {
		 var bnum=$("#bnum").val();
		 alert("삭제페이지이동");
		 location.href="/delete.do?bnum="+bnum;
	})
})

	
   
</script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
 
        <h1>글 상세보기</h1>
        
       
		<button type="button" id="updateBtn">수정</button>

		<button type="button" id="deleteBtn">삭제</button>
	
        <button > <a href="/list2.do">HOME</a> </button>
        <table border="2" width="600">
        
        <tr>
           <th>글번호</th>
           <th>글제목</th>
           <th>작성자</th>
           <th>날짜</th>
           <th>조회수</th>
           <th>내용</th>
           <th>분류</th>
        </tr>
        
         <tr>
	            <td>   <input type="text"  id="bnum" name="bnum" value="${board.bnum }" /></td>
	            <td>  <input type="text" name="title" value="${board.title }" /></td>
	            <td>  <input type="text" name="writer" value="${board.writer }" /> 
	      </td>
	            <td>  <input type="text" name="bdate" value="${board.bdate }" /></td>
	            <td>  <input type="text" name="bcnt" value="${board.bcnt }" /></td>
	            <td> <input type="text" name="bcontent" value="${board.bcontent }" /></td>
	            <td>  <input type="text" name="btype" value="${board.btype }" /> </td>
        </tr>
        
        
        
        </table>
        <!-- 댓글 -->
        
        
      <div id="reply">
      <h2>댓글목록</h2>
  <ol class="replyList">
    <c:forEach items="${replyList}" var="replyList">
      <li>
        <p>
        작성자 : ${replyList.writer}<br />
        작성 날짜 :  <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd" />
        </p>

        <p>${replyList.content}</p>
        <div>
  <button type="button" class="replyUpdateBtn" data-rno="${replyList.rnum}"  data-rno="${ replyList.bnum}">수정</button>
  <button type="button" class="replyDeleteBtn" data-rno="${replyList.rnum}">삭제</button>
</div>
      </li>
    </c:forEach>   
  </ol>
</div>


<form name="replyForm" method="post">
  <input type="hidden" id="bnum" name="bnum" value="${board.bnum}" />
  
  <div>
    <label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer" />
    <br/>
    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
  </div>
  <div>
 	 <button type="button" class="replyWriteBtn">작성</button>
  </div>
</form>
<script type="text/javascript">

$(".replyWriteBtn").on("click", function(){
	
	  alert("댓글작성완료");
	  var formObj = $("form[name='replyForm']");
	  formObj.attr("action", "replyWrite.do");
	  formObj.submit();
	});
	
//댓글 수정 View
$(".replyUpdateBtn").on("click", function(){
	 var bnum=$("#bnum").val();
	 
	 var rnum= $("rnum").val();
	location.href = "replyUpdateView?bnum="+bnum+"&rnum="+rnum;
});
		
//댓글 삭제 View
$(".replyDeleteBtn").on("click", function(){
	 var bnum=$("#bnum").val();
	 var rnum= $("rnum").val();
	location.href = "replyDeleteView?bnum="+bnum+ "&rnum="+rnum;
});
</script>

</body>
</html>