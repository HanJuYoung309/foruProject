package co.kr.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.board.service.ReplyService;
import co.kr.board.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Autowired
	public ReplyService replyService;
	
	//RedirectAttributes는 redirect했을때 값들을 물고 이동
	@RequestMapping(value = "replyWrite.do", method=RequestMethod.POST)
	public String replyWrite(ReplyVO vo,RedirectAttributes rttr,Model model) {
		System.out.println("댓글 작성 컨트롤러 호출....");
		replyService.writeReply(vo);
		
		rttr.addAttribute("read", vo.getBnum());
		
		//리다이텍트-> 상세보기로 리다이텍트된다 
		return "redirect:getBoard.do?bnum="+vo.getBnum();
		
	}
	
	
	

}
