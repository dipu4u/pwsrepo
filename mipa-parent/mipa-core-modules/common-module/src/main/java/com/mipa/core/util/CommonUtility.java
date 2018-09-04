package com.mipa.core.util;

import java.util.Collection;
import java.util.Objects;

public class CommonUtility {

	public static final boolean isEmpty(final String str) {
		return Objects.isNull(str) || str.trim().length() == 0;
	}
	
	public static final boolean isEmpty(final Collection<?> collection) {
		return Objects.isNull(collection) || collection.isEmpty();
	}
	
	public static final boolean validPaginationValues(final Integer start, final Integer limit) {
		return Objects.nonNull(start) && Objects.nonNull(limit) && start >= 0 && limit >=0;
	}

}