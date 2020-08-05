package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Aspect: �������� ����ִ� Ŭ����(����, �α�.., Ʈ�����..)
//Advice: Aspect Ŭ������ ����ִ� ������(�Ѹ���� Aspect ���� �Լ�)
//JoinPoint: advice �Լ��� ����Ǵ�  �Լ�.  =   �������� ����  �Լ��� �ǹ�
//PointCut: Joinpoint�� �κ����� ������ ����Ǵ� �Լ����� ����
//Weaving: Advice�� �����ϴ� ����

@Component
@Aspect   //�������� ��� �ִ� Ŭ����(����, �α�.., Ʈ�����..)
public class LogAdvice {
	@Before("within(edu.bit.board.*)")  //�̹����� ��ü.
	//@Before("within(edu.bit.board.service*)")   //���⿡ �ִ� ���� ����ְڴ�.  �����ִ� �Լ��� ���۵Ǳ� �ٷ� ������ printLogging()�� �Լ��� �ְڴ�.
	public void printLogging() {
		System.out.println("������ - ����Ʈ �α�");
	}  //�������� �ٸ��� �Լ��� �� �Լ��� ����־�ڴ�!!  ������������ xml������ ���� �� �� �ֵ��� �������Ҵ�.

}
