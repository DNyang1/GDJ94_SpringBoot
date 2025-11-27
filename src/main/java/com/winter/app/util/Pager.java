package com.winter.app.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pager {
	
	private String kind;
	private String search;
	private Long page;
	private Long perPage;
	private Long perBlock;
	private Long startNum;
	private Long begin;
	private Long end;
	
	public Long getPerBlock() {
	    if (this.perBlock == null) this.perBlock = 5L;
	    return this.perBlock;
	}

	public Long getPerPage() {
	    if (this.perPage == null) this.perPage = 10L;
	    return this.perPage;
	}

	public Long getPage() {
	    if (this.page == null || this.page < 1) this.page = 1L;
	    return this.page;
	}

	public void pageing(Long totalCount) {
	    Long perPage = this.getPerPage();
	    Long perBlock = this.getPerBlock();
	    Long page = this.getPage();

	    Long totalPage = totalCount / perPage;
	    if (totalCount % perPage != 0) totalPage++;

	    Long totalBlock = totalPage / perBlock;
	    if (totalPage % perBlock != 0) totalBlock++;

	    Long curBlock = page / perBlock;
	    if (page % perBlock != 0) curBlock++;

	    this.begin = (curBlock - 1) * perBlock + 1;
	    this.end = curBlock * perBlock;

	    if (curBlock >= totalBlock) {
	        this.begin = (totalBlock - 1) * perBlock + 1;
	        this.end = totalPage;
	        this.page = totalPage;
	    }

	    this.startNum = (this.page - 1) * perPage;
	}

	
}
