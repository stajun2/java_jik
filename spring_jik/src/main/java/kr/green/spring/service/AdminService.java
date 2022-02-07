package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.MemberVO;

public interface AdminService {

	List<MemberVO> getMemberList();

	boolean updateAuthority(MemberVO member);

}
