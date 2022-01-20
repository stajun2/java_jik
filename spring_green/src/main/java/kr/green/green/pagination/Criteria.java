package kr.green.green.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page; 
	private int perPageNum;
	private String search;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.search = "";
	}

	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
}
