package com.order.dao;

import com.order.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
}
