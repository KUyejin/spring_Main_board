package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import edu.bit.board.vo.BoardVO;



public interface BoardMapper { 
	//DAO�� ���� ����
	//Mapper�� ������ �������̽��� ����
	
	public abstract List<BoardVO> getList();
	//getList�� xml���� ó���Ѵ�

	public abstract BoardVO read(int bno);

	@Delete("Delete from mvc_board where bId = #{bno}") // xml���� �������ص� ��
	public abstract int delete(int bno);
	
	
	
	//public abstract void insertBoard(@Param("bName") String bName, @Param("bTitle") String bTitle, @Param("bContent") String bContent);
	public abstract void insertBoard(BoardVO boardvo);
	
	
// [reply_view�� �ۼ��� �ʿ����]=============================================================================	
	//@Select("select * from mvc_board where bId = #{bno}")
	//public abstract BoardVO reply_view(int bno);

	
	
// [reply]===================================================================================================================================	
	//public abstract void insertReply(@Param("bId")int getbId, @Param("bName")String getbName, @Param("bTitle") String getbTitle, @Param("bContent") String getbContent, 
	//		@Param("bGroup") int getbGroup, @Param("bStep") int getbStep, @Param("bIndent") int getbIndent);	
	
	public abstract void updateShape(@Param("boardVO")BoardVO boardVO);
	public abstract void insertReply(BoardVO boardVO);
	//@Param("boardVO")�� �ѱ�� �ִ� �� mapper.xml������ #{boardVO.bGroup}, #{boardVO.bStep}�� �ް� �ִ� ? ��� ����?
	//#{bGroup}�� getbName�� ���������� ȣ���Ѵ�
	//#{}�� getter�Լ��� ȣ���ϴ� ��
	

//[modify]=============================================================================================================================	
//	@Update("update mvc_board set bName = #{bName}, bTitle = #{bTitle}, bContent = #{bContent} where bId = #{bid}")
//	public abstract void modify(@Param("bid") int bId, @Param("bName") String bName, @Param("bTitle") String bTitle, @Param("bContent") String bContent);
	
	public abstract void modify(@Param("boardVO")BoardVO boardVO);
	
	
	
// [upHit]==================================================================================================	
	@Update("update mvc_board set bHit = bHit + 1 where bId = #{bno}")
	public abstract void upHit(int bno);
}	
	
	
	
	
	
	
	
	