package kr.green.green.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	private Date me_birth;
	private String me_address;
	private String me_phone;
	public String getMe_id() {
		return me_id;
	}
	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}
	public String getMe_pw() {
		return me_pw;
	}
	public void setMe_pw(String me_pw) {
		this.me_pw = me_pw;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public String getMe_gender() {
		return me_gender;
	}
	public void setMe_gender(String me_gender) {
		this.me_gender = me_gender;
	}
	public Date getMe_birth() {
		return me_birth;
	}
	
	public void setMe_birth(String me_birth) {
		SimpleDateFormat format;
		try {
			format = new SimpleDateFormat("yyyy-MM-dd");
			this.me_birth = format.parse(me_birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getMe_address() {
		return me_address;
	}
	public void setMe_address(String me_address) {
		this.me_address = me_address;
	}
	public String getMe_phone() {
		return me_phone;
	}
	public void setMe_phone(String me_phone) {
		this.me_phone = me_phone;
	}
	@Override
	public String toString() {
		return "MemberVO [me_id=" + me_id + ", me_pw=" + me_pw + ", me_name=" + me_name + ", me_gender=" + me_gender
				+ ", me_birth=" + me_birth + ", me_address=" + me_address + ", me_phone=" + me_phone + "]";
	}
}
