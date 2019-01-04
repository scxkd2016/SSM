package com.order.dao;

import com.order.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository <OrderDetail,String> {

}
