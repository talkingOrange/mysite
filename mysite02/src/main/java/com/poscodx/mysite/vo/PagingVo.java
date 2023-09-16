package com.poscodx.mysite.vo;

public class PagingVo {
	private int page = 1; // 현재 page
	private int totalCount; // 전체 글 개수
	private int beginPage; // 보이는 시작 페이지
	private int endPage; // 보이는 끝 페이지
	private int limit = 5; // limit
	private int pagination = 5; // 보일 페이지 수
	boolean prev; // prev 버튼 유무
	boolean next; // next 버튼 유무

	public PagingVo() {
	}

	public PagingVo(int page, int totalCount, int beginPage, int endPage, int limit, int pagination, boolean prev,
			boolean next) {
		super();
		this.page = page;
		this.totalCount = totalCount;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.limit = limit;
		this.pagination = pagination;
		this.prev = prev;
		this.next = next;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		paging();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Paging [page=" + page + ", totalCount=" + totalCount + ", beginPage=" + beginPage + ", endPage="
				+ endPage + ", limit=" + limit + ", pagination=" + pagination + ", prev=" + prev + ", next=" + next
				+ "]";
	}

	private void paging() {

		// 마지막으로 보일 페이지: 보일 페이지 양에
		endPage = ((int) Math.ceil(page / (double) pagination)) * pagination;

		// 시작 페이지
		beginPage = endPage - (pagination - 1);

		// 총 페이지 개수
		int totalPage = (int) Math.ceil(totalCount / (double) limit);

		// nexticon과 previcon 관리
		if (totalPage <= endPage) {
			endPage = totalPage;
			next = false;
		} else {
			next = true;
		}
		prev = (beginPage == 1) ? false : true;
	}

}
