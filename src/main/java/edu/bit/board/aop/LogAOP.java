package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//Aspect: �������� ����ִ� Ŭ����(����, �α�.., Ʈ�����..)
//Advice: Aspect Ŭ������ ����ִ� ������(�Ѹ���� Aspect ���� �Լ�)
//JoinPoint: advice �Լ��� ����Ǵ�  �Լ�.  =   �������� ����  �Լ��� �ǹ�
//PointCut: Joinpoint�� �κ����� ������ ����Ǵ� �Լ����� ����
//Weaving: Advice�� �����ϴ� ����

@Component   //��ü�� �ø���. aop-context.xml��<context:component-scan base-package="edu.bit.board.aop"></context:component-scan> �Է�.
@Aspect
public class LogAOP {
	
	
	@Pointcut("execution(* edu.bit.board..*")
	private void pointcutMethod() {
		
	}
	//�ش� �Լ� ����Ʈ�� ����
	
	@Around("within(edu.bit.board..*)") 
	//joinpoint: ������ �Լ��� �־�� �ϴ� �Լ�,list�� ���弭�񽺿� ����ִ� �Լ� �� �־�� �ϴ� ��ɿ� ���� �Լ�
	//������Ʈ�ѷ� ����Ʈ�� ������ �ִ�.
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{  
		String signatureStr = joinpoint.getSignature().toShortString();  //������Ʈ�ѷ� ����Ʈ�� ������ �ִ�.
		System.out.println( signatureStr + "is start.");
		
		
		long st = System.currentTimeMillis(); //������
		
		try {
			Object obj = joinpoint.proceed();  //���弭��.list��.(����Ʈ����)�ٽɱ�ɿ��� �ش��Լ� �����Ű�� �κ�.
			
			return obj;
		} finally {
			
			long et = System.currentTimeMillis();  //������
			
			System.out.println( signatureStr + "is finished.");
			System.out.println( signatureStr + "����ð� : " + (et - st));
		}
		
	}
}