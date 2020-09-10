package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
//test
@Controller
@Log4j
@AllArgsConstructor  //�Һ�. ��Ʈ�ѷ��� ���ؼ� ���弭�� ������ �ɹ��� ���� ������ �ؼ� �ڵ����� ������. �����ڰ� ������ �Ʒ��� auto�� �־��ش�.
public class BoardController {
	

	private BoardService service; //����Ͻ�����(ó���ؾ��Ұ͵�)�� ���弭�񽺿� ����
	//new�� ���߰� AutoWired(Inject)�� ���ߴµ� ��� ����������?
	//-������5������ �����ڰ� ������ Auto(�ڵ�)�� �־��ش�
	//@AllArgsConstructor�� �־��ָ� �ڵ����� �ؿ� �ڵ带 �������ش�
    //@Inject
	//public BoardService(BoardService service){	
	//    this.service = service;
	
	
	
	@GetMapping("/list") //get������� �ްڴ�
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());		
		//test�Ϸ��� url(/list)�� �޾Ƴ��� �Ѵ� - �޾Ƴ��� ��ü�� ��Ĺ�̴� ->�׽�Ʈ�Ϸ��� ��������������				
	}
	
	
	//�ڡ���ŷ�� ���� ù��° ���  -> 1. ���ڵ� ���
	/*
	 * @GetMapping("/list") public String list(HttpServletRequest req, Model model)
	 * {
	 * 
	 * HttpSession session = request.getSession(); UserVO = (UserVO)
	 * session.getAttribute("user");
	 * 
	 * if(user != null) { model.addAttribute("list", service.getList()); }else {
	 * retrun "redirect:" }
	 *}
	 */
	
  
	@GetMapping("/content_view") //get������� �ްڴ�
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		model.addAttribute("content_view", service.get(boardVO.getbId()));//model��id�� ����
		
		return "content_view";
	}	
	
	
	@GetMapping("/delete") //get������� �ްڴ�
	public String delete(BoardVO boardVO) {
		log.info("delete");
		service.remove(boardVO.getbId());
		
		return "redirect:list";
	}
	

	@GetMapping("/write_view") 
	public String write_view() {
		log.info("write_view");
			
		return "write_view";
	}
	
	
//===================================================================================================	
	/*
	 * @GetMapping("/write") public String write_view(BoardVO boardVO) throws Exception { 
     * log.info("write");
	 * service.write(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent()
	 * );
	 * return "redirect:list"; }
	 */
	
	@GetMapping("/write") 
	public String write_view(BoardVO boardVO) throws Exception {
		log.info("write");
	    service.write(boardVO);			
		return "redirect:list";
	}
//===========================================================================================	


	
	@GetMapping("/reply_view") 
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view");			
		model.addAttribute("reply_view", service.get(boardVO.getbId()));			
		return "reply_view";
	}
	
			

//====================================================================================================	
	/*
	 * @GetMapping("/reply") public String reply (BoardVO boardVO, Model model) {
	 * log.info("reply");
	 * service.reply(boardVO.getbId(), boardVO.getbName(),
	 * boardVO.getbTitle(),boardVO.getbContent(), boardVO.getbGroup(),
	 * boardVO.getbStep(), boardVO.getbIndent());
	 * return "redirect:list"; }
	 */
				
	@GetMapping("/reply") 
	  public String reply (BoardVO boardVO, Model model) throws Exception{
		  log.info("reply");		  
		  service.reply(boardVO);		  		  
		  return "redirect:list"; 
	}
		 
	
	
//=========================================================================================================	
//	@GetMapping("/modify") 
//	public String modify (BoardVO boardVO, Model model) {
//		log.info("modify");		
//		service.modify(boardVO.getbId(), boardVO.getbName(), boardVO.getbTitle(),boardVO.getbContent());					
//		return "redirect:list";
//	}
	
	@PostMapping("/modify") 
	public String modify (BoardVO boardVO, Model model) {
		log.info("modify");		
		service.modify(boardVO);					
		return "redirect:list";
	}
	
	
	@GetMapping("/jquerylist") 
	public String jquerylist(Model model) {
	   log.info("jquerylist");
	   model.addAttribute("list", service.getList()); 
	   return "jqueryList";
	}	
	
	//ajax ���
	   @RequestMapping("/ajax/list")
	   public String ajaxList() {
	      
	      log.info("ajaxList");
	      return "ajaxlist";
	   }
	   
	   
	   
	   
	   @GetMapping("/list3") //void�̹Ƿ� list3�� jsp���� �Ѵ�.
		 public void list2(Criteria cri, Model model) {	
			 log.info("list3");
			 log.info(cri);
			 model.addAttribute("list", service.getList(cri));	
			 
			 int total = service.getTotal(cri);
			 log.info("total" + total);
			 
			 model.addAttribute("pageMaker", new PageDTO(cri,total));	
		 }
	   //Criteria�� Ŀ��� ��ü
	   
	   
	
}
	

