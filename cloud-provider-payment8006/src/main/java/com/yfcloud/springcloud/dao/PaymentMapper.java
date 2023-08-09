package com.yfcloud.springcloud.dao;

import com.yfcloud.springcloud.entitles.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    public int insertPayment(Payment payment);

    public Payment getPayment(Long id);
}
