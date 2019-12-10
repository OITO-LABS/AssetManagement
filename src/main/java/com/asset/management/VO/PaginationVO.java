
package com.asset.management.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationVO {
	private int page;
	private String searchkey;
	private int limit;
	private String sortOrder;
	private String sortKey;
}

