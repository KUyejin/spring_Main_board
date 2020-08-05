package edu.bit.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringRunner.class)  //1. �������׽�Ʈ
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//3. �ش� xml�� ���� ���ؼ� �ʿ��ϴ�.
@Log4j//3. log �Һ�
public class BoardMapperTest {
	//5.������ 3���� ����� �ִ�.(������, setter�Լ�, �ʵ忡 ���̷�Ʈ�� �ִ� ��� @AutoWired�� �Է��ϸ� �Ǵµ�, ���� ���� ����̴�.(�ʵ带 ���� �� ���� ��������.)
	
	@Setter(onMethod_= @Autowired)  //5. ������ۿ� ���� �����Լ��� �����մϴ�. �Һ�
	//@Inject
	//2. mapper�� dao��. �׸��� �������̽���. Ŀ�ؼ�Ǯ�� �����ͼ� db������ �ؾ� �ϴϱ� Ŀ�ؼ� Ǯ�� ���� ������ �����;� �Ѵ�. 
	//4. root-context.xml�� �ִ� id dataSource(Ŀ�ؼ�Ǯ)�� �����;� �Ѵ�. �׸��� �ٽ���(mybatis)�� sqlSessionFactory��. 
	private BoardMapper boardMapper;  
	
	@Test
	public void testBoardMapper() {
		log.info(boardMapper); //6. ��ü�� ������ null�� �����ڰ�, �ƴϸ� ���� ��������.
		}
	
	//7. test����. �ݺ���
	@Test
	public void testBoardMapperList() {
		List<BoardVO>list = boardMapper.getList();
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getbContent());
			log.info(boardVO.getbName()); 
			//���� ��� ���� �׽�Ʈ �ߴ��� ppt�� ������� �մϴ�. junit ���� ������.
			//test get�� �� ��ƾ� ������ ���� �� �ִ�.
			
			//8. ��Ʈ�ѷ��� �׽�Ʈ �غ���. ��Ʈ�ѷ��� ��ü�����ؼ� mapping list �޾Ƴ� �� �ֳ�? ��ü�� �����Ѵٰ� ������ �Ǵ°� �ƴմϴ�. ����̱� ������ �������� ���ؼ� ����(��Ĺ)�� �޾Ƴ����ؿ�.
			//'/list'��� ���� url�� �޾Ƴ����ϴµ�, ���� ���������� �ϴ� ���� �ƴ�, ��Ĺ���� url ġ�� ������ ���� �޾Ƴ��� �մϴ�. ���� �������� ������ �մϴ�. �������� ������ �׽�Ʈ �� �ٿ��� ��������   
		}
	}

}
