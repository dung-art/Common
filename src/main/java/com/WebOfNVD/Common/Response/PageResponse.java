package com.WebOfNVD.Common.Response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.googlecode.jmapper.JMapper;

public class PageResponse<D, S> extends SuccessResponse {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Page<S> page;
	private List<D> list;

	public PageResponse(Page<S> page, JMapper<D, S> mapper) {
		this.page = page;
		list = new ArrayList<>();
		page.getContent().forEach(s -> list.add(mapper.getDestination(s)));
	}

	public List<D> getContent() {
		return list;
	}

	public int getTotalPages() {
		return page.getTotalPages();
	}

	public int getNumberOfElements() {
		return page.getNumberOfElements();
	}

	public int getSize() {
		return page.getSize();
	}

	public Sort getSort() {
		return page.getSort();
	}

	public int getNumber() {
		return page.getNumber();
	}

	public long getTotalElements() {
		return page.getTotalElements();
	}
}
