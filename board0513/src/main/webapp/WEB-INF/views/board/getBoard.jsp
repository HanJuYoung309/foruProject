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
/* JSP SCRIPT */
var bbsidx = ${bbsidx};
var useridx = ${useridx};
 
var btn_like = document.getElementById("btn_like");
 btn_like.onclick = function(){ changeHeart(); }
 
/* 좋아요 버튼 눌렀을떄 */
 function changeHeart(){ 
     $.ajax({
            type : "POST",  
            url : "/clickLike",       
            dataType : "json",   
            data : "bbsidx="+bbsidx+"&useridx="+useridx,
            error : function(){
                Rnd.alert("통신 에러","error","확인",function(){});
            },
            success : function(jdata) {
                if(jdata.resultCode == -1){
                    Rnd.alert("좋아요 오류","error","확인",function(){});
                }
                else{
                    if(jdata.likecheck == 1){
                        $("#btn_like").attr("src","/home/img/ico_like_after.png");
                        $("#likecnt").empty();
                        $("#likecnt").append(jdata.likecnt);
                    }
                    else if (jdata.likecheck == 0){
                        $("#btn_like").attr("src","/home/img/ico_like_before.png");
                        $("#likecnt").empty();
                        $("#likecnt").append(jdata.likecnt);
                        
                    }
                }
            }
        });
 }
 



	
   
</script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
 
        <h1>글 상세보기</h1>
        
       
		<button type="button" id="updateBtn">수정</button>

		<button type="button" id="deleteBtn">삭제</button>
	
        <button > <a href="/list2.do">HOME</a> </button>
        
        <c:choose>
    <c:when test="${likecheck eq '0' or empty likecheck}"> <!-- likecheck가0이면 빈하트-->
        <img src="/home/img/ico_like_before.png" 
             id="btn_like" align="left" style="cursor:pointer; width: 20px;">
    </c:when>
    <c:otherwise> <!-- likecheck가1이면 빨간 하트-->
        <img src="/home/img/ico_like_after.png" 
              id="btn_like" align="left" style="cursor:pointer; width: 20px;">
    </c:otherwise>
</c:choose>
<div id="likecnt" style="margin-left:5px;">${likecnt}</div>
        
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
	location.href = "replyUpdateView?bnum="+bnum
					+ "&rnum="+$(this).attr("data-rno");
});
		
//댓글 삭제 View
$(".replyDeleteBtn").on("click", function(){
	var bnum=$("#bnum").val();
	
	location.href = "replyDeleteView?bnum="+bnum
		+ "&rnum="+$(this).attr("data-rno");
});
</script>

</body>
</html>