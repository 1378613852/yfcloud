package com.yfcloud.springcloud.service;

import com.yfcloud.springcloud.entitles.Payment;

public interface PaymentService {
    public int insertPayment(Payment payment);

    public Payment getPayment(Long id);
}
