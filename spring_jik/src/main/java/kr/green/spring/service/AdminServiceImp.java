package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List<MemberVO> getMemberList() {
		
		return memberDao.selectMemeberList();
	}

	@Override
	public boolean updateAuthority(MemberVO member) {
		if(member == null || member.getMe_id() == null 
				|| member.getMe_authority() == null
				|| member.getMe_authority().equals("슈퍼 관리자"))
			return false;
		MemberVO dbUser = memberDao.getMember(member.getMe_id());
		if(dbUser == null)
			return false;
		dbUser.setMe_authority(member.getMe_authority());
		memberDao.updateMember(dbUser);
		return true;
	}
}
