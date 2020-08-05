package edu.bit.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor 
 class RestBoardSpring4BeforeController {
   
   
   private BoardService boardservice; 
   

   @ResponseBody  //restful���� ������̼�.  http ���������� body������ �����ٴ� �ǹ�.//�޼����� ����Ÿ���� ������ �ٸ��� ó���Ѵٴ� ���� ���
   @RequestMapping("/restful/before")
   public List<BoardVO> before() {  //�ڹٰ�ü�� ��� body�� ��������(�����ϴ���).. �������� �˾Ƽ� json���� xml�� ������.
      //�ڹ� ��ü�� XML�� �ٲ��ִ� ����(��ü)�� �ִ�.  pom.xml���� jackson, gson
      log.info("rest/before");
      List<BoardVO> list = boardservice.getList();
     
      return list;  //return���� �������� view�̸��̾��µ� ������ �з������� �ٲ���.
      //�������� .jsp �� �������� ���������� ������ ������ list�� ��ȯ�ϰ� ����. ���ο� �з������̴�. 
      
   }
   
   
   
}