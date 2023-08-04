package br.board.model.vo;

import java.util.List;

public class PageData {
	private List<BRBoard> bList;
	private String pageNavi;
	
	public PageData() {
		super();
	}
	public PageData(List<BRBoard> bList, String pageNavi) {
		super();
		this.bList = bList;
		this.pageNavi = pageNavi;
	}
	public List<BRBoard> getbList() {
		return bList;
	}
	public void setbList(List<BRBoard> bList) {
		this.bList = bList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
