package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);

	List<BoardVO> getBoardList(@Param("type")String type);

	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("board")BoardVO dbBoard);

	void insertFile(@Param("file")FileVO fileVo);

	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);

}
