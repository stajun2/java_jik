package day17;

import java.util.*;

public class ExdMapEx1 {

	public static void main(String[] args) {
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("abc123", "123123");
		//비밀번호는 중복 되도 회원 정보가 추가가 됨
		userInfo.put("qwe123", "123123");
		//아이디는 중복 되면 회원 정보가 추가되지 않고 수정 됨
		userInfo.put("qwe123", "12341234");
		System.out.println(userInfo);
		userInfo.remove("abc123");
		System.out.println(userInfo);
		System.out.println(userInfo.get("qwe123"));
		System.out.println(userInfo.containsKey("qwe123"));
	}
}
