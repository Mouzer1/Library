package by.bsuir.library.dao;

import java.util.List;

import by.bsuir.library.bean.Order;

public interface OrderDao extends BaseDao <Order>{
	
	List<Order> getOrdersByUserId (int userId, int active);
	List<Order> getActiveOrders ();
	void updateOrderClose(int orderId);
	
}
