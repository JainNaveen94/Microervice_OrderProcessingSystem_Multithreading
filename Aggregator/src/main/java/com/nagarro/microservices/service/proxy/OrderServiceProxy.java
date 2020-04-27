package com.nagarro.microservices.service.proxy;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.microservices.model.Order;

//@FeignClient( contextId = "orderClient", name = "netflix-zuul-api-gateway-server")
//@RibbonClient(name = "Order")
public interface OrderServiceProxy {
	
	@GetMapping("/order/order/list/{userId}")
	public List<Order> getOrdersOfUser(@PathVariable("userId") long userId);

}
