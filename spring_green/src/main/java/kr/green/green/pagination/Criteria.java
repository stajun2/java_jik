package kr.green.green.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page; 
	private int perPageNum;
	private String search;
	private String type;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.search = "";
		this.type ="일반";
	}

	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	public String getTypeTitle() {
		if(type != null && type.equals("공지"))
			return "공지사항";
		return "게시글";
	}
}
