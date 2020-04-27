package com.nagarro.microservices.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.microservices.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Order> getOrders() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Order>> typeReference = new TypeReference<List<Order>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/order.json");
		try {
			return mapper.readValue(inputStream,typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Order>();
	}

}
