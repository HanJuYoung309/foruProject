<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>댓글 수정 페이지</title>
</head>
<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			var bnum= $("bnum").val();
			
			$(".cancel_btn").on("click", function(){
				location.href = "readView?bnum="+bnum;
			})
			
		})
		
	</script>
<body>
<h1>댓글 수정 페이지 </h1>
<section id="container">
				<form name="updateForm" role="form" method="post" action="replyUpdate">
					<input type="hidden" name="bnum" value="${replyUpdate.bnum}" readonly="readonly"/>
					<input type="hidden" id="rnum" name="rnum" value="${replyUpdate.rnum}" />
				
					<table>
						<tbody>
							<tr>
								<td>
									<label for="content">댓글 내용</label><input type="text" id="content" name="content" value="${replyUpdate.content}"/>
								</td>
							</tr>	
							
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="button" class="cancel_btn">취소</button>
					</div>
				</form>
			</section>
</body>
</html>