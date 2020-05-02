package com.nagarro.microservices.constant;

public class HQLQueryConstants {
	
	public static final String SELECT_TOP_N_ORDER = "from Order o1 where :n >= (select count(DISTINCT orderAmount) from Order o2 where o2.orderAmount >= o1.orderAmount) order by orderAmount DESC";

}
