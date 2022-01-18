package kr.green.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {
	//총 게시글 갯수. endPage 결정할 때 활용, 게시글 번호를 연속되게 출력할 때 활용
	private int totalCount;
	private int startPage;	//시작 페이지
	private int endPage;		//마지막 페이지
	private boolean prev;		//이전 버튼 활성화 여부
	private boolean next;		//다음 버튼 활성화 여부
	private int displayPageNum;	//한 페이지네이션에서 보여주는 페이지 갯수
	private Criteria criteria;	//현재 선택된 페이지 정보
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		/* starPage와 endPage는 현재 페이지 정보인 criteria와 displayPageNum을 이용하여 계산
		 * displayPageNum이 10이고 현재 페이지가 3페이지면 startPage = 1, endPage = 10이 되도록 계산 */
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		
		startPage = (endPage - displayPageNum)+1;
		/* 총 콘텐츠 갯수를 이용하여 마지막 페이지네이션에서 마지막 페이지 번호를 계산 */
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		
		/* 현재 페이지에 계산된 현재 페이지메이커의 마지막 페이지 번호와 실제 마지막 페이지 번호를 비교하여
		 * 작은 값이 마지막 페이지 번호가 됨 */
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		/* 페이지네이션 설정에 따라 달라질수 있다 
		 * 다음 버튼 클릭하면 현재 페이지에서 다음 페이지로 이동
		 * 현재 페이지가 1페이지이면 다음 버튼을 클릭하면 2페이지로 이동
		 * 이전 버튼 클릭하면 현재 페이지에서 이전 페이지로 이동
		 * */
		//위 설정에서 이전 버튼은 1페이지에만 비활성화시키면됨
		prev = criteria.getPage() == 1 ? false : true;
		//startPage가 1페이지이면 이전 버튼을 비활성화
		//prev = startPage == 1 ? false : true;
		//위 설정에서 다음 버튼은 마지막 페이지에서만 비활성화시키면됨
		next = criteria.getPage() == tempEndPage? false : true;
		//next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
	}

	public PageMaker(int totalCount, int displayPageNum, Criteria criteria) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.criteria = criteria;
		calcData();
	}
}
