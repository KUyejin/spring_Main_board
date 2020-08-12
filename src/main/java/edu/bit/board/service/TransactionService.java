package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class TransactionService {
	
	private BoardMapper boardMapper;
		
    public void transionTest1() {   
	    log.info("transionTest1()�׽�Ʈ");
	    
	    BoardVO boardVO = new BoardVO();
	    boardVO.setbContent("Ʈ�����1");
	    boardVO.setbName("Ʈ�����1");
	    boardVO.setbTitle("Ʈ�����1");
	    
	    boardMapper.insertBoard(boardVO);
	    
	    
	    boardVO.setbContent("Ʈ�����1-1");
	    boardVO.setbName("Ʈ�����1-1");
	    boardVO.setbTitle("Ʈ�����1-1");
	    
	    boardMapper.insertBoard(boardVO); 
	    
	  //db�� Ʈ�����1�� 1-1�� ->500������ ���
    }
        

	public void transionTest2() {
	  log.info("transionTest2()�׽�Ʈ");
	    
	    BoardVO boardVO = new BoardVO();
	    boardVO.setbContent("Ʈ�����2");
	    boardVO.setbName("Ʈ�����2");
	    boardVO.setbTitle("Ʈ�����2");
	    
	    boardMapper.insertBoard(boardVO);
	    
	    
	    boardVO.setbContent("Ʈ�����2-1");
	    boardVO.setbName("Ʈ�����2-1");
	    boardVO.setbTitle("Ʈ�����2-1");
	    
	    boardVO = null;
	    
	    boardMapper.insertBoard(boardVO);		
	
	  //db�� Ʈ�����2���� ->500������ ���
	}
	
	
	@Transactional
	public void transionTest3() {
		  log.info("transionTest3()�׽�Ʈ");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("Ʈ�����3");
		    boardVO.setbName("Ʈ�����3");
		    boardVO.setbTitle("Ʈ�����3");
		    
		    boardMapper.insertBoard(boardVO);
		    
		    
		    boardVO.setbContent("Ʈ�����3-1");
		    boardVO.setbName("Ʈ�����3-1");
		    boardVO.setbTitle("Ʈ�����3-1");
		    
		    //Ʈ������� ���� �Ϻη� ������ ���� �� 
		    //db�� Ʈ����� �ϳ��� �ȵ� -> 500������
		    //@Transactional�� �������·� �ѹ��� ������ - �μ�Ʈ�ߴ� �͵� ������
		    boardVO = null;
		    
		    boardMapper.insertBoard(boardVO);		
		}
	
	@Transactional
	public void transionTest4() {
		  log.info("transionTest4()�׽�Ʈ");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("Ʈ�����4");
		    boardVO.setbName("Ʈ�����4");
		    boardVO.setbTitle("Ʈ�����4");
		    
		    boardMapper.insertBoard(boardVO);
		    		   
		    
		    throw new RuntimeException("RuntimeExcepion for rollback"); 
		    //���������� �������� �� - RuntimeExcepion����  
		    //-> �׷��Ƿ� Ʈ������� �������� ���·� �ѹ����ش�	-> db�� �ƹ������� ���� ����
		    
		    
		}
	
	@Transactional
	public void transionTest5() throws IOException  {
		  log.info("transionTest5()�׽�Ʈ");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("Ʈ�����5");
		    boardVO.setbName("Ʈ�����5");
		    boardVO.setbTitle("Ʈ�����5");
		    
		    boardMapper.insertBoard(boardVO);
		    		   
		  throw new IOException("IOException for rollback");
		  //try catch�� ���ų� throws�� ������
		  //�ʰ� �˾Ƽ� �϶�� ����ó���϶�� ���������� ��Ű�� ������ �ѹ��� �ȵȴ�.
		  //�׷��� ������ db�� "Ʈ�����5"�� ���Եȴ�
		  
		  

	}
	
	//transionTest5()�� �ѹ��� �ǰ� �Ϸ���?
	//@Transactional�� rollbackFor �ɼ��� �̿��ϸ� Rollback�� �Ǵ� Ŭ������ ����������
	//Exception���ܷ� �ѹ��� �Ϸ��� ������ ���� �����ϸ� �˴ϴ�
	//@Transactional(rollbackFor = Exception.class) 
	//�������� ���ܸ� ������ ���� �ִ�.
	//@Transactional(rollbackFor = {RuntimeExcepion.class, Exception.class})
	
	@Transactional(rollbackFor = Exception.class) //����������
	public void transionTest6() throws IOException  {
		  log.info("transionTest5()�׽�Ʈ");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("Ʈ�����6");
		    boardVO.setbName("Ʈ�����6");
		    boardVO.setbTitle("Ʈ�����6");
		    
		    boardMapper.insertBoard(boardVO);
		    		   
		  throw new IOException("IOException for rollback");

        //�ѹ��� �Ǿ��� ������ db�� �ƹ������� ���� �ʴ´�
	}
	

	

}
