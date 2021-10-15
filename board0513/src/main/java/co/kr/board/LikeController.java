package co.kr.board;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.LikeService;

@Controller
public class LikeController {
	
	@Autowired
	LikeService likeSerivce;
	
	@RequestMapping(value = "/like.do", method = RequestMethod.POST)
	public ModelAndView Like_modify(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");

		likeSerivce.insert(param);
		
		return json;
	}
	
	@RequestMapping(value = "/likeDelete.do", method = RequestMethod.POST)
	public ModelAndView Like_delete(int bnum,int usernum) {
		ModelAndView json = new ModelAndView("jsonView");
		
		likeSerivce.delete(bnum,usernum);
		
		return json;
	}
	
	@RequestMapping(value = "/likeSu.do", method = RequestMethod.GET)
	public ModelAndView Like_su(int bnum) {
		ModelAndView json = new ModelAndView("jsonView");
		
		int su = likeSerivce.likeCnt(bnum);
		json.addObject("su", su);
		return json;
	}

}
