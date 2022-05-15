package com.toy.trelloapi.model;

import io.swagger.annotations.ApiModelProperty;

public class PagingInfo {
	@ApiModelProperty(
		notes = "한번에 조회할 Record 수",
		example = "20"
	)
	private int pagingWindowSize;
	@ApiModelProperty(
		notes = "전체 Record 수",
		example = "1000"
	)
	private int rowsTotalCount;
	@ApiModelProperty(
		notes = "현재 페이지 위치",
		example = "1"
	)
	private int currentPageIndex;
	@ApiModelProperty(
		notes = "전체 페이지 수",
		example = "23"
	)
	private int pageTotalCount;
	@ApiModelProperty(
		notes = "Record 시작 위치",
		example = "1"
	)
	private int itemStartIndex;
	@ApiModelProperty(
		notes = "Record 끝 위치",
		example = "5"
	)
	private int itemEndIndex;

	PagingInfo(final int pagingWindowSize, final int rowsTotalCount, final int currentPageIndex, final int pageTotalCount, final int itemStartIndex, final int itemEndIndex) {
		this.pagingWindowSize = pagingWindowSize;
		this.rowsTotalCount = rowsTotalCount;
		this.currentPageIndex = currentPageIndex;
		this.pageTotalCount = pageTotalCount;
		this.itemStartIndex = itemStartIndex;
		this.itemEndIndex = itemEndIndex;
	}

	public static PagingInfo.PagingInfoBuilder builder() {
		return new PagingInfo.PagingInfoBuilder();
	}

	public int getPagingWindowSize() {
		return this.pagingWindowSize;
	}

	public int getRowsTotalCount() {
		return this.rowsTotalCount;
	}

	public int getCurrentPageIndex() {
		return this.currentPageIndex;
	}

	public int getPageTotalCount() {
		return this.pageTotalCount;
	}

	public int getItemStartIndex() {
		return this.itemStartIndex;
	}

	public int getItemEndIndex() {
		return this.itemEndIndex;
	}

	public void setPagingWindowSize(final int pagingWindowSize) {
		this.pagingWindowSize = pagingWindowSize;
	}

	public void setRowsTotalCount(final int rowsTotalCount) {
		this.rowsTotalCount = rowsTotalCount;
	}

	public void setCurrentPageIndex(final int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public void setPageTotalCount(final int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public void setItemStartIndex(final int itemStartIndex) {
		this.itemStartIndex = itemStartIndex;
	}

	public void setItemEndIndex(final int itemEndIndex) {
		this.itemEndIndex = itemEndIndex;
	}

	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof PagingInfo)) {
			return false;
		} else {
			PagingInfo other = (PagingInfo)o;
			if (!other.canEqual(this)) {
				return false;
			} else if (this.getPagingWindowSize() != other.getPagingWindowSize()) {
				return false;
			} else if (this.getRowsTotalCount() != other.getRowsTotalCount()) {
				return false;
			} else if (this.getCurrentPageIndex() != other.getCurrentPageIndex()) {
				return false;
			} else if (this.getPageTotalCount() != other.getPageTotalCount()) {
				return false;
			} else if (this.getItemStartIndex() != other.getItemStartIndex()) {
				return false;
			} else {
				return this.getItemEndIndex() == other.getItemEndIndex();
			}
		}
	}

	protected boolean canEqual(final Object other) {
		return other instanceof PagingInfo;
	}

	public int hashCode() {
		boolean PRIME = true;
		int result = 1;
		/*int result = result * 59 + this.getPagingWindowSize();
		result = result * 59 + this.getRowsTotalCount();
		result = result * 59 + this.getCurrentPageIndex();
		result = result * 59 + this.getPageTotalCount();
		result = result * 59 + this.getItemStartIndex();
		result = result * 59 + this.getItemEndIndex();*/
		return result;
	}

	public String toString() {
		int var10000 = this.getPagingWindowSize();
		return "PagingInfo(pagingWindowSize=" + var10000 + ", rowsTotalCount=" + this.getRowsTotalCount() + ", currentPageIndex=" + this.getCurrentPageIndex() + ", pageTotalCount=" + this.getPageTotalCount() + ", itemStartIndex=" + this.getItemStartIndex() + ", itemEndIndex=" + this.getItemEndIndex() + ")";
	}

	public static class PagingInfoBuilder {
		private int pagingWindowSize;
		private int rowsTotalCount;
		private int currentPageIndex;
		private int pageTotalCount;
		private int itemStartIndex;
		private int itemEndIndex;

		PagingInfoBuilder() {
		}

		public PagingInfo.PagingInfoBuilder pagingWindowSize(final int pagingWindowSize) {
			this.pagingWindowSize = pagingWindowSize;
			return this;
		}

		public PagingInfo.PagingInfoBuilder rowsTotalCount(final int rowsTotalCount) {
			this.rowsTotalCount = rowsTotalCount;
			return this;
		}

		public PagingInfo.PagingInfoBuilder currentPageIndex(final int currentPageIndex) {
			this.currentPageIndex = currentPageIndex;
			return this;
		}

		public PagingInfo.PagingInfoBuilder pageTotalCount(final int pageTotalCount) {
			this.pageTotalCount = pageTotalCount;
			return this;
		}

		public PagingInfo.PagingInfoBuilder itemStartIndex(final int itemStartIndex) {
			this.itemStartIndex = itemStartIndex;
			return this;
		}

		public PagingInfo.PagingInfoBuilder itemEndIndex(final int itemEndIndex) {
			this.itemEndIndex = itemEndIndex;
			return this;
		}

		public PagingInfo build() {
			return new PagingInfo(this.pagingWindowSize, this.rowsTotalCount, this.currentPageIndex, this.pageTotalCount, this.itemStartIndex, this.itemEndIndex);
		}

		public String toString() {
			return "PagingInfo.PagingInfoBuilder(pagingWindowSize=" + this.pagingWindowSize + ", rowsTotalCount=" + this.rowsTotalCount + ", currentPageIndex=" + this.currentPageIndex + ", pageTotalCount=" + this.pageTotalCount + ", itemStartIndex=" + this.itemStartIndex + ", itemEndIndex=" + this.itemEndIndex + ")";
		}
	}
}
