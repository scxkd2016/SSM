package com.order.dao;

import com.EurekaApplicationTests;
import com.order.enums.OrderStatusEnum;
import com.order.enums.PayStatusEnum;
import com.order.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterDaoTest extends EurekaApplicationTests {
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}