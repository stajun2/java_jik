package kr.green.green.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.CommentVO;

public interface CommentDAO {

	void insertComment(@Param("comment")CommentVO comment);

}
