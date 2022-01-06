package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		System.out.println(user);
		return null;
	}

	@Override
	public boolean signup(MemberVO user) {
		if(user == null)
			return false;
		//필수항목인 아이디가 null인지 체크
		if(user.getMe_id()== null)
			return false;
		//필수항목인 비번이 null인지 체크
		if(user.getMe_pw()==null)
			return false;
		//기타 필수항목들 체크를 해야함
		
		//이미 가입된 아이디인지 체크. 아이디 중복 검사
		if(memberDao.getMember(user.getMe_id()) != null)
			return false;
		memberDao.signup(user);
		return true;
	}
}
