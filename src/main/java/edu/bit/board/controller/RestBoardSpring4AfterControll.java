package edu.bit.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
//spring v4.0 ���� ����(@Controller + @ResponseBody)  //�������� ����
@RestController //(Controller+@ResponseBody) ������ ������� ���� ������ �����°�. 
//@Controller
@Log4j
@AllArgsConstructor 
 class RestBoardSpring4AfterController {
   
   
   private BoardService boardservice; 
   
   //�޼����� ����Ÿ���� ������ �ٸ��� ó���Ѵٴ� ���� ��� 
   //@ResponseBody  //@RestController������ ResponseBody�ʿ����.
   @CrossOrigin //���� �������� 
   @RequestMapping("/restful/after")
   public List<BoardVO> before() {  //�ڹٰ�ü�� ��� body�� ��������(�����ϴ���).. �������� �˾Ƽ� json���� xml�� ������.
      //�ڹ� ��ü�� XML�� �ٲ��ִ� ����(��ü)�� �ִ�.  pom.xml���� jackson, gson
      log.info("rest/after");
      List<BoardVO> list = boardservice.getList();
     
      return list;  //return���� �������� view�̸��̾��µ� ������ �з������� �ٲ���.
      //�������� .jsp �� �������� ���������� ������ ������ list�� ��ȯ�ϰ� ����. ���ο� �з������̴�. 
      //�Ǵٸ� @RestController ������ �����ڴٴ� �ǹ�.
      //�̹����� �����͸� ���� �޾ƿͺ���. view�� ���� jquesryList ctrl c,v�Ͽ� ajaxlist
      
   }
   
   
   //content_view.jsp���� delete�޾Ƴ�����
    @DeleteMapping("/rest/delete/{bId}")//�� ����
   //@RequestMapping(value = "/rest/delete/{bId}", method = RequestMethod.DELETE)
	public int restDelete(@PathVariable("bId") int bId) {
   	
   	    log.info("restDelete");
		return  boardservice.remove(bId);
	}
   
   
}