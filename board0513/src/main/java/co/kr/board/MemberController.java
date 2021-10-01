package co.kr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			
			service.register(vo);
			
			return "user/login";
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
			
			return "redirect:/";
		}
		
	
	

}
