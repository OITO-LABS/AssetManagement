
package com.asset.management.VO;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationVO {
	int page;
	Optional<String> searchkey;
	int limit;
}

