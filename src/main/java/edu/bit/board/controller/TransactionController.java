package edu.bit.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.service.BoardService;
import edu.bit.board.service.TransactionService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor  
public class TransactionController {
	
    private TransactionService transactionService;
    
    @GetMapping("/tran/{num}") //����ƮǮ�� �޾ƿ� - URLȰ��
    public void transaction(@PathVariable ("num") int num) throws IOException {
    	if(num == 1) {
    		log.info("transionTest1 �׽�Ʈ");
    		transactionService.transionTest1();
    	}else if(num == 2) {
    		log.info("transionTest2 �׽�Ʈ");
    		transactionService.transionTest2();
    	}else if(num == 3) {
    		log.info("transionTest3 �׽�Ʈ");
    		transactionService.transionTest3();
    	}else if(num == 4) {
    		log.info("transionTest4 �׽�Ʈ");
    		transactionService.transionTest4();
    	}else if(num == 5) {
    		log.info("transionTest5 �׽�Ʈ");
    		transactionService.transionTest5();
    	}else if(num == 6) {
    		log.info("transionTest6 �׽�Ʈ");
    		transactionService.transionTest6();
    	}

    
    
    }
}
	

