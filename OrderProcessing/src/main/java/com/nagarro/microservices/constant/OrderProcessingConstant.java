package com.nagarro.microservices.constant;

public class OrderProcessingConstant {
	
	/***** Order API Related Constants *****/
	public final static String ORDER_INCORRECT_ID = "No Order Exist With ID :: ";
	public final static String ORDER_NOT_FOUND = "No Order Exist";
	
	/***** User API Related Constants *****/
	public static final String USER_INCORRECT_ID = "User Not Found With ID :: ";
	public static final String USER_NOT_FOUND = "User Not Found";
	
	/***** Product API Related Constants *****/
	public static final String PRODUCT_NOT_FOUND = "Product not Found";
	public static final String PRODUCTS_NOT_FOUND = "Some Products Not Available";
	public static final String PRODUCT_INCORRECT_ID = "Product is not Available with this Product ID :: ";
	public static final String QUANTITY_UPDATED_SUCCESS = "Quantity Updated Successfully";
	public static final String QUANTITY_UPDATED_FAILER = "Quantity Updated Failure due to some server issue";
	public static final String INVALID_QUANTITY = "Some Products has Invalid Quantity";
	public static final String HIGER_QUANTITY = "You Enter the Higer Quantity then Available Quantity";
	
	/***** Payment API Related Constants *****/
	public static final String PAYMENT_NOT_FOUND = "Payment Details Not Found";
	public static final String PAYMENT_INCORRECT_ID = "Payment Details Not Found with this User ID :: ";
	public static final String PAYMENT_FAILED_INSUFFICENT = "Payment Failed due to insufficient balance";
	public static final String PAYMENT_FAILED_SERVER = "Payment is not Updated Due to Server Issue";
	public static final String PAYMENT_SUCCESS_SERVER = "Paymemt is Successfully Updated";
	
	
	/***** Order Process Constants *****/
	public static final String ORDER_FAILER = "Order is not Process due to some Server Issue";
	public static final String ORDER_SUCCESS = "Order is Placed Successfully ($-$))";
}
