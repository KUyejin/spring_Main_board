package edu.bit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



//�츮�� ���±��� datasource�ѰŴ� servlet-context.xml�� �־���. ��Ʈ�ѷ���  servlet-context.xml�� ����ִ�. ��ü ������ �ؼ� �� ��ü�� ���� ����.
//Ŭ���̾�Ʈ�� ������������ url�� �Է��ϰ� �Ǹ� ����ó �������� ó�����ִµ�, ����ó ���� ���� ���� web.xml���� �̸� �� �� ���� ��ģ��. �ѱ� utf ó��. ����ó���������� web.xml���� ��ü �����Ѵ�. 
//(���)��Ʈ�ѷ��ϱ� ���ؼ��� �ڵ鷯 ����, �ڵ鷯 �ƴ�Ÿ���� ��Ʈ�ѷ��� �ִ� �Լ� �����ϰ�, viewresolver������ servlet.xml���� �����س����ϴ�. �׷��� �������̼� �帮���ؼ� ��ü�����߽��ϴ�. 
//�� ���ԵǸ��, db�κ��� �ְ�, dao��  root.xml�� �����߽��ϴ�.

//9.
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) //�� �� �� �о�´�. root-context.xml�� <context:component-scanbase-package="edu.bit.board.service"> ���⼭ �о���δ�.
@Log4j
//8. test�������.
public class BoardControllerTest {
	//10. BoardControllerTest �ȿ��ٰ� webApplicationContext(������ mvc= IOC�����̳��̴�. ��ü ���δ� �����ϴ� IOC�����̳� ������ ������ �ƴմϴ�.) ���� �����ȴ�?
	//    �꿡 ����  setter�Լ� �����, ctx�� 4����Ʈ ��ü �ּ� �ְڴٴ°ǵ�, ��� �������°���?
	//	  set�Լ� �ϳ� ���� autowired�϶�µ�, webApplicationContext �ȿ� ��Ʈ�ѷ��� ���ִ�. servlet, root �д´�.
	//    �������� �����ӿ�ũ�� �������ϴ� ��Ȳ�� �´�. ��Ʈ�� c+v�Ұ� �ƴϴ�.
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	
	//11. mockMvc �ȿ� ctx �־������, �ش� ��Ʈ�ѷ��� ��Ʈ�� �� �� �ִ�. 
	//MockMvc��? ���� ��ü�� ��������� �׽�Ʈ�� �ʿ��� ��ɸ� ������ ��¥ ��ü�� ���� ���ø����̼� ������ �������� �ʰ� ������ mvc ������ ������ �� �ִ� Ŭ���� �ǹ��Ѵ�.
	//�Ѹ���� ���� ������ �� �� �ִ�. (���� ���� �� �� �ִ� �Լ��� ������ �ִ�.) 
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/*
	 @GetMapping("/list")
	 public void list(Model model) {	��Ʈ�ѷ����� �տ� void�� ������, �𵨾غ信�� ���ϰ��� list.jsp�� ���ϴ�. 
		 log.info("list");
		 model.addAttribute("list", service.getList());	
	 }*/
	
	@Test
	public void testList() throws Exception {
		 mockMvc.perform(get("/list"))  //get������� list ġ�� ����,
		 .andExpect(status().isOk())//���� ����.  ���� �˾Ƽ� �׽�Ʈ ���ش�.
		 .andDo(print()) //andDo: ���信 ���� �������� �޼����� �ѷ��ش�.
         .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	}

	//�����׽�Ʈ �ߴٴ°� ��Ͽ� �� ����......!!!!!!!!!!!!!!!!!

}
