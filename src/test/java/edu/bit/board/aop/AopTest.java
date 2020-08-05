package edu.bit.board.aop;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.bit.board.controller.BoardControllerTest;
import edu.bit.board.service.BoardService;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/aop-context.xml" }) //�� �� �� �о�´�. root-context.xml�� <context:component-scanbase-package="edu.bit.board.service"> ���⼭ �о���δ�.
@Log4j
public class AopTest {
	
	//@Setter(onMethod_=@Autowired)
	@Inject
	private BoardService service;
	
	
	@Test
	public void testServiceAop() {
		//log.info(service.getClass().getName());
		log.info("����Ʈ ����");
		log.info(service.getList());
		log.info("����Ʈ ��");
	}

}
