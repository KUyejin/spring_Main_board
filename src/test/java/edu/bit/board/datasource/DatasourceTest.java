package edu.bit.board.datasource;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class) //�������׽�Ʈ�� ���� ȯ�汸�� �ڵ�.  ��Ĺ�� �������ص� ioc�����̳ʸ� �ҷ��ͼ� �׽�Ʈ�ϴ� ���̴�.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //IOC �����̳ʸ� Ȱ���Ͽ� �ش��θ� Ž��
@Log4j //src/main/resources ������ log4 ������Ƽ ������ �����ϰ� src/main/java ���� �ش� ������ ��������.
public class DatasourceTest {

	@Inject //ioc�����̳ʿ� �ִ� ������ �ҽ��� �Ʒ� ��ü�� �����Ѵ�.
	private DataSource dataSource;
	
	@Test
	public void testDatasource() {
		//fail("Not yet implemented");
		
		System.out.println("Result: " + dataSource);
		
	}

}


//�׽�Ʈ ���� : ����(�Լ�) -> ���� -> �ý��� -> �μ�
//���Ľ� �ڸ�Ʈ: �����׽�Ʈ�� � �������� �ߴ����� ���� PPT�� ���� �����Ͻʽÿ�. ���� �̷��Ա��� �Ĳ��ϰ� ���� �ȴٶ�� ���� �����ؾ��Ѵ�.


