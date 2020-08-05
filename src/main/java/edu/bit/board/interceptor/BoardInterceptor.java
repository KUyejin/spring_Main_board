package edu.bit.board.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.board.vo.UserVO;
import lombok.extern.log4j.Log4j;


/**
 * Handles requests for the application home page.
 */
//�ڡ���ŷ�� ���� �ι�° ���  ->2.���ͼ��� (prehandler, posthandler ��ü�� ������Ų��)
//filter�� web.xml�� ���� (filter�� ���� �����̱� ������)
//db���� root.xml���� ����
//��Ʈ�ѱ��� servlet.xml���� ����

@Log4j
 public class BoardInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		//preHandle�Լ��ȿ��� ��Ʈ�ѷ� �������� ���´�.
	
		log.info("preHandler ����");

		//request��ü�ȿ� session�� �����´�
		HttpSession session = request.getSession();
		
		//loginó���� ����ϴ� ����� ������ ��� �ִ� ��ü�� ������
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user == null) {
			log.info("user�� null");
			
			//�α����� �ȵǾ� �ִ� �����̹Ƿ� �α��� ������ �ٽ� �������� (redirect)
			response.sendRedirect(request.getContextPath()); //context��  �ٽ� �� �������� ���� ������.
			
			return false; //���̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� false�� ��ȯ��
		}
				
		return true;
	}
	
	@Override //������ ��ģ�� ����� �����´�
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	        throws Exception{
		
		super.postHandle(request,  response,  handler,  modelAndView);
		log.info("postHandle ����");		
	}

	
}	
	

