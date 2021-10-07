<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<script type="text/javascript">
function replyDelete() {

	   $.ajax({
			url:"/replyDelete.do",
			type:"POST",
			data:$("#deleteForm").serialize(),
			dataType:"JSON",
				
		  success: function (result) {
			   console.log(result);
			   alert("댓글 삭제 성공!");
			   var bnum=$("bnum").val();
			   location.href="/getBoard.do?bnum="+bnum;
			   
			}
					
	   })
}
	</script>
<body>
<h1>댓글 삭제 페이지 </h1>
<section id="container">
				<form name="deleteForm" role="form" >
					<input type="hidden" name="bnum" id="bnum" value="${replyDelete.bnum}" readonly="readonly"/>
					<input type="hidden" id="rnum" name="rnum" value="${replyDelete.rnum}" />
				
					<div>
						<p>삭제 하시겠습니까?</p>
						<button type="submit" class="delete_btn">예 삭제합니다.</button>
						<button type="button" class="cancel_btn">아니오. 삭제하지 않습니다.</button>
					</div>
				</form>
			</section>
</body>
</html>