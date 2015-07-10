package com.digitexx.dao;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import com.digitexx.dao.EmployeeComparator;
import com.digitexx.dto.DtoForm;

public class EmployeeComparator implements Comparator<DtoForm> {

	public int compare(DtoForm o1, DtoForm o2) {
		int age1 = o1.getId();
		int age2 = o2.getId();
		if (age1 > age2) {
			return 1;
		} else if (age1 == age2) {
			return 0;
		} else {
			return -1;
		}
	}

}