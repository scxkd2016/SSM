package com.order.dao;

import com.EurekaApplicationTests;
import com.order.pojo.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDetailDaoTest extends EurekaApplicationTests {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertTrue(result != null);

    }
}