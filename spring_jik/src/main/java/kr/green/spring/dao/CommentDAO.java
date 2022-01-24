package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.CommentVO;

public interface CommentDAO {

	void insertComment(@Param("comment")CommentVO comment);

}
