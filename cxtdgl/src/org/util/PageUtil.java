package org.util;


public class PageUtil {
	private int pageSize;// 每页显示的记录数量
	private int totalRecord;// 总记录数
	private int currentPage;// 当前页码
	// ***********************************************
	private int totalPage;// 总页数
	private int currentStartRecord;// 当前页开始记录
	private int currentEndRecord; // 当前页结束记录
	private int start;// 开始记录
	private int end;// 结束记录
	private int upPage;// 向上翻页页码
	private int downPage;// 向下翻页页码

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页显示的记录数量
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 设置总记录数
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 设置总页数
		int _totalPage = 1;
		if (getTotalRecord() % getPageSize() == 0) {
			// 如果总记录数除以每页显示条数可以整除，商就是总页码
			_totalPage = this.getTotalRecord() / this.getPageSize();
		} else {
			// 如果总记录数除以每页显示条数不能整除，商加1才是总页码
			_totalPage = this.getTotalRecord() / this.getPageSize() + 1;
		}
		if (_totalPage < 1) {
			_totalPage = 1;
		}
		this.setTotalPage(_totalPage);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置页码
	 */
	public void setCurrentPage(int currentPage) {
		if (currentPage > this.getTotalPage()) {
			this.currentPage = this.getTotalPage();
		} else {
			this.currentPage = currentPage;
		}
		// 设置当前页开始记录
		int _currentStartRecord = 0;
		if (this.getTotalRecord() != 0) {
			_currentStartRecord = (this.getCurrentPage() - 1) * this.getPageSize() + 1;
		}
		if (_currentStartRecord < 0) {
			_currentStartRecord = 0;
		}
		this.setCurrentStartRecord(_currentStartRecord);
		// 设置当前页结束记录
		int _currentEndRecord = this.getCurrentPage() * this.getPageSize();
		if (_currentEndRecord > this.getTotalRecord()) {
			_currentEndRecord = this.getTotalRecord();
		}
		this.setCurrentEndRecord(_currentEndRecord);
		// 开始记录
		int _start = (this.getCurrentPage() - 1) * this.getPageSize();
		if (_start < 0) {
			_start = 0;
		}
		this.setStart(_start);
		// 结束记录
		int _end = this.getCurrentPage() * this.getPageSize();
		if (_end > this.getTotalRecord()) {
			_end = this.getTotalRecord();
		}
		this.setEnd(_end);
		// 向上翻页页码
		int _upPage = this.getCurrentPage() - 1;
		if (_upPage < 1) {
			_upPage = 1;
		}
		this.setUpPage(_upPage);
		// 向下翻页页码
		int _downPage = this.getCurrentPage() + 1;
		if (_downPage > this.getTotalPage()) {
			_downPage = this.getTotalPage();
		}
		this.setDownPage(_downPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentStartRecord() {
		return currentStartRecord;
	}

	public void setCurrentStartRecord(int currentStartRecord) {
		this.currentStartRecord = currentStartRecord;
	}

	public int getCurrentEndRecord() {
		return currentEndRecord;
	}

	public void setCurrentEndRecord(int currentEndRecord) {
		this.currentEndRecord = currentEndRecord;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getUpPage() {
		return upPage;
	}

	public void setUpPage(int upPage) {
		this.upPage = upPage;
	}

	public int getDownPage() {
		return downPage;
	}

	public void setDownPage(int downPage) {
		this.downPage = downPage;
	}
}
