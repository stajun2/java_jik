package kr.green.green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO user) {
		//회원가입 안되는 경우 확인해서 회원가입 진행
		if(user == null)
			return false;
		//아이디 가능한지 확인
		if(user.getMe_id() == null || user.getMe_id().trim().length() == 0)
			return false;
		//비밀번호 가능한지 확인
		
		//성별 가능한지 확인
		
		//가능하다면 회원가입을 진행
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public MemberVO login(MemberVO user) {
		if(user== null || user.getMe_id()==null 
			|| user.getMe_id().trim().length() == 0)
			return null;
		MemberVO dbUser = memberDao.selectMember(user.getMe_id());
		if(dbUser == null)
			return null;
		if(!passwordEncoder.matches(user.getMe_pw(), dbUser.getMe_pw()))
			return null;
		return dbUser;
	}
}
