package co.kr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.board.service.MemberService;
import co.kr.board.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	public MemberService service;
	
	    // 회원가입 get
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public String getRegister() throws Exception {
			logger.info("get register");
			
			return "user/register";
		}
	
		// 회원가입 post
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String postRegister(MemberVO vo) throws Exception {
			logger.info("post register");
			
			int result= service.idChk(vo);
			
			 try{
				if(result==1) {
					return "user/register";
				}else if (result==0) {
					service.register(vo);
				}
				// 요기에서~ 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기 
				// 존재하지 않는다면 -> register
			}catch (Exception e) {
			    throw new RuntimeException();	
			}
			return "redirect:login.do";
		}
		
		@RequestMapping(value = "/login.do", method = RequestMethod.GET)
		public String loginForm(MemberVO vo) throws Exception{
			
			logger.info("로그인페이지이동");
			return "user/login";
		}
		
		
		@RequestMapping(value = "/login.do", method = RequestMethod.POST)
		public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
			logger.info("post login");
			
			HttpSession session = req.getSession();
			MemberVO login = service.login(vo);
			
			if(login == null) {
				session.setAttribute("member", null);
				rttr.addFlashAttribute("msg", false);
			}else {
				session.setAttribute("member", login);
			}
			
			//리다이텍트는 X /으로 넘아감 
			return "board/list";
		}
		
		@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
		public String logout(HttpSession session) throws Exception{
			
			session.invalidate();
			
			return "redirect:login.do";
		}
		
		
		//수정페이지이동
		@RequestMapping(value="/memberUpdateView.do", method = RequestMethod.GET)
		public String registerUpdateView() throws Exception{
			
			return "user/memberUpdateView";
		}

		//수정
		@RequestMapping(value="/memberUpdate.do", method = RequestMethod.POST)
		public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{
			
			service.memberUpdate(vo);
			
			session.invalidate();
			
			return "redirect:/";
		}
	
		// 회원 탈퇴 get
		@RequestMapping(value="/memberDeleteView.do", method = RequestMethod.GET)
		public String memberDeleteView() throws Exception{
			
			System.out.println("회원탈퇴 페이지이동");
			return "user/memberDeleteView";
		}
		
		
		
		
		// 회원 탈퇴 post
		@RequestMapping(value="/memberDelete", method = RequestMethod.POST)
		public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
			
			// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
			MemberVO member = (MemberVO) session.getAttribute("member");
			// 세션에있는 비밀번호
			String sessionPass = member.getUserPass();
			// vo로 들어오는 비밀번호
			String voPass = vo.getUserPass();
			
			//세션에있는 비밀번호가맞지않을 경우에 처리 
			if(!(sessionPass.equals(voPass))) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:user/memberDeleteView";
			}
			service.memberDelete(vo);
			session.invalidate();
			return "redirect:login.do";
		}
		
		//패스워드체크
		@ResponseBody
		@RequestMapping(value = "/passChk", method = RequestMethod.POST)
		public int passChk(MemberVO vo) {
			int result=service.passChk(vo);
			return result;
		}
		
		
		//아이디중복체크
		@ResponseBody
		@RequestMapping(value = "/idChk", method = RequestMethod.POST)
		public int idChk(MemberVO vo) {
			int result=service.idChk(vo);
			return result;
		}

}
