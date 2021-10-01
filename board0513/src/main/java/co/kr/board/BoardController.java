package co.kr.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;
import co.kr.board.service.MemberService;
import co.kr.board.service.ReplyService;
import co.kr.board.vo.BoardVO;
import co.kr.board.vo.MemberVO;
import co.kr.board.vo.ReplyVO;


@Controller
public class BoardController {
	
	//github테스트
	@Autowired
	public BoardService service;
	
	@Autowired
	public ReplyService replyService;
	
	@Autowired
	public MemberService memberService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardHome(){
		
		System.out.println(" 홈 이동 ..... ");
		
		return "home";
		
	}
	
	@RequestMapping(value = "/list2.do", method = RequestMethod.GET)
	public String boardListForm(){
		
		//System.out.println(" 홈...-로그인페이지");
		
		return "board/list";
		
	}
	
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView boardList(int page,String type,String keyword){
		
		// 이름을 jsonView
		ModelAndView json = new ModelAndView("jsonView");

		List<BoardVO> list = service.list(page, type, keyword);
		// 날짜형식 맞춰주기
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date date = new Date();

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setBdate(simple.format(date));
		}

		// 소수점까지 나오기위해 1.0을곱한다
		// 끝페이지
		int endPage = (int) (Math.ceil(page * 1.0 / 5) * 5);

		// 처음
		int startPage = endPage - 4;

		if (startPage <= 0) {
			startPage = 1;
		}

		// 총 게시글 갯수
		int total = service.total();

		// 전체페이지
		int totalPage = (int) Math.ceil(total * 1.0 / 10);

		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// 이전
		boolean prev = page > 1;
		// 다음
		boolean next = page < endPage;

		json.addObject("list", list);
		json.addObject("endPage", endPage);
		json.addObject("startPage", startPage);
		json.addObject("prev", prev);
		json.addObject("next", next);

		return json;
		
	}
	
	//상세보기
	@RequestMapping(value = "/getBoard.do", method = RequestMethod.GET)
	public String getBoard(Model model,int bnum) {
		//BoardVO boardVO= new BoardVO();
		service.cntUpdate(bnum);

	    BoardVO board= service.getBoard(bnum);
		model.addAttribute("board",board);
		
	
		List<ReplyVO> replyList= replyService.replyList(board.getBnum());
		model.addAttribute("replyList",replyList);
		return "board/getBoard";
		
	}
	
	//입력폼 
	@RequestMapping(value = "/insert.do" , method = RequestMethod.GET)
	public String insertForm(Model model,HttpSession session) {
		
		int max= service.cntMax();
		model.addAttribute("max",max+1);
		
		String user= (String) session.getAttribute("userid");
		model.addAttribute("userid",user);
		
		return "board/insert";
	}
	
	//입력
	@RequestMapping(value = "/insertProcess.do" , method = RequestMethod.POST)
	public ModelAndView insert(BoardVO boardVO,HttpSession session,Model model) {
	
	    String user= (String) session.getAttribute("userid");
		model.addAttribute("userid",user);
			
		ModelAndView json=new ModelAndView("jsonView");
	
        json.addObject("result", service.insert(boardVO));
        
    
		
		return json;
	
	}
	
	
	//수정 페이지이동
	@RequestMapping(value = "/update.do" , method = RequestMethod.GET)
	public String updateForm(int bnum,Model model,HttpSession session) {
		
		String user = (String) session.getAttribute("userid");
		model.addAttribute("userid", user);

		BoardVO board = service.getBoard(bnum);
		model.addAttribute("board", board);

		System.out.println("수정페이지 이동");
	
		return "board/update";
	
	}
	
	//수정
	@RequestMapping(value = "/update.do" , method = RequestMethod.POST)
	public ModelAndView update(int bnum,HttpSession session,Model model) {
	
		String user = (String) session.getAttribute("userid");
		model.addAttribute("userid", user);
		//return "update";
		ModelAndView json= new  ModelAndView("jsonView");
		json.addObject("result", service.update(bnum));
		
		
		return json;
	
	}
	  //삭제 페이지이동
		@RequestMapping(value = "/delete.do" , method = RequestMethod.GET)
		public String deleteForm(int bnum,Model model, HttpSession session) {
		
			String user = (String) session.getAttribute("userid");
			model.addAttribute("userid", user);
			
			BoardVO board = service.getBoard(bnum);
			model.addAttribute("board", board);
		
				
			return "board/delete";
		
		}
		
	
	//삭제
		@RequestMapping(value = "/delete.do" , method = RequestMethod.POST)
		public ModelAndView delete(int bnum,Model model, HttpSession session) {
			String user = (String) session.getAttribute("userid");
			model.addAttribute("userid", user);
			//return "update";
			ModelAndView json= new  ModelAndView("jsonView");
			json.addObject("result", service.delete(bnum));
			
			return json;
		
		}
	
	
	
}
