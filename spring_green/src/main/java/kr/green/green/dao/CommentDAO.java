package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.CommentVO;

public interface CommentDAO {

	void insertComment(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("bd_num")Integer bd_num, @Param("cri")Criteria cri);

	int selectCommentCount(@Param("bd_num")Integer bd_num);

}
