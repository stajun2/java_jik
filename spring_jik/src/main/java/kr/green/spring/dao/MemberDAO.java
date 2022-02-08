package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MainCategoryVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.MiddleCategoryVO;
import kr.green.spring.vo.SubCategoryVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	void insertMember(@Param("user")MemberVO user);

	void updateMember(@Param("user")MemberVO input);

	MemberVO findMember(@Param("user")MemberVO member);

	List<MemberVO> selectMemeberList();

	void updateAutoLogin(@Param("user")MemberVO user);

	MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);

	MemberVO pramTest1(@Param("user")MemberVO user);
	
	MemberVO pramTest2(MemberVO user);

	MemberVO pramTest3(@Param("me_id")String me_id, @Param("me_name")String me_name);

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddleCategory(@Param("mi_ma_num")Integer mi_ma_num);

	List<SubCategoryVO> selectSubCategory(@Param("su_mi_num")Integer su_mi_num);

}
