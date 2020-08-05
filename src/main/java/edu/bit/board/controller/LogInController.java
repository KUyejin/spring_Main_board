package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.service.BoardService;
import edu.bit.board.service.LogInService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor  
public class LogInController {
	
	private LogInService loginService;
	
	@GetMapping("/")
	public String home() {
		log.info("home");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		log.info("post login");
		
		//Session ó���� ���� Session��ü HttpServletRequest�ȿ� ����
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserVO login = loginService.loginUser(id,pw);
		
		if(login == null) {
			session.setAttribute("user", null);
			
			//spring3���� �����ϴ� RedirectAttributes�� ����ϸ� redirect post ������ �����մϴ�
			//������ ��ȸ���Դϴ�. ���ΰ�ħ�ϸ� ���󰡴� �������̹Ƿ� �������� ���� ���/�Ұ��� �Ǵ��� �� �ϼž� �մϴ�
			
			rttr.addFlashAttribute("msg",false); //�����̷�Ʈ ���� �÷��ÿ� �����ϴ� �޼ҵ��. �����̷�Ʈ ���Ŀ��� �Ҹ��Ѵ�.

		}else {
			session.setAttribute("user",login);
		}
		//return "redirect:/";
		return "link";
		
	}
	
	//�α��� ������ �� session�� �ִ���?
	//session��ü��  HttpSession���� �޾ƿ´�
	
	@RequestMapping(value = "/logout")
        public String logout(HttpSession session) throws Exception{
			log.info("/member/logout");
			
			session.invalidate(); //�޸𸮿��� ���������� �� - �� DELETE�� �ƴѰ�? �������÷��Ͱ� ���������� ����� �� ������ ������ ���������� �ʴ´�. ->�޸𸮿� ��������
			                      //                                 .invalidate�� �������÷��Ϳ��� �޸� ����� ����̶�� �˷��ִ°�
			
			return "redirect:/";
			
		
	}
	
}	
	

