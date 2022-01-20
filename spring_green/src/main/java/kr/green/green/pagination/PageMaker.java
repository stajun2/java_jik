package kr.green.green.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria criteria;
	
	public void calcData() {
		//현재 페이지네이션에서 마지막 페이지. 현재 페이지에 따라 달라짐 
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		//실제 마지막 페이지. 게시글 수가 변하지 않으면 현재 페이지에 상관없이 고정
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//prev = criteria.getPage() == 1 ? false : true;
		//next = criteria.getPage() == tempEndPage ? false:true;
		prev = startPage == 1 ? false : true;
		next = endPage == tempEndPage ? false : true;
	}

	public PageMaker(int totalCount, int displayPageNum, Criteria criteria) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.criteria = criteria;
		calcData();
	}
}
