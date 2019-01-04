package com.order.service.impl;

import com.order.client.ProductClient;
import com.order.dao.OrderDetailDao;
import com.order.dao.OrderMasterDao;
import com.order.dto.CartDto;
import com.order.dto.OrderDto;
import com.order.enums.OrderStatusEnum;
import com.order.enums.PayStatusEnum;
import com.order.pojo.OrderDetail;
import com.order.pojo.OrderMaster;
import com.order.pojo.ProductInfo;
import com.order.service.OrderService;
import com.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Autowired
    private ProductClient productClient;
    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyUtil.genKey();
        //查询商品信息
        List<String> productlist = orderDto.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productlist);
        //计算总价
        BigDecimal orederAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail:
             orderDto.getOrderDetailList()) {
            for (ProductInfo productInfo :
                productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orederAmout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orederAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genKey());
                    //订单详情入库
                    orderDetailDao.save(orderDetail);
                }
            }
        }
        //扣库存
        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream().map(e->new CartDto(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDtoList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderAmount(orederAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        return orderDto;
    }
}
