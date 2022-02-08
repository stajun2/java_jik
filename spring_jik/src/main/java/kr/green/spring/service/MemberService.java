package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.MainCategoryVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.MiddleCategoryVO;
import kr.green.spring.vo.SubCategoryVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO user);

	boolean idDuplicated(String id);

	MemberVO updateMember(MemberVO input, MemberVO user);

	String findId(MemberVO member);

	String findPw(MemberVO member);

	void updateAutoLogin(MemberVO user);

	MemberVO selectMemberBySessionId(String value);

	void paramTest();

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddleCategory(Integer mi_ma_num);

	List<SubCategoryVO> selectSubCategory(Integer su_mi_num);

}
