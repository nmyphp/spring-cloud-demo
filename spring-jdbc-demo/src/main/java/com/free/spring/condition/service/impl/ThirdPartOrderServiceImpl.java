package com.free.spring.condition.service.impl;

import com.free.spring.condition.dao.ThirdPartOrderDao;
import com.free.spring.jdbc.demo.common.CommonCondition;
import com.free.spring.jdbc.demo.dao.po.Order;
import com.free.spring.jdbc.demo.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional(CommonCondition.class)
@Service
public class ThirdPartOrderServiceImpl implements OrderService {

    @Autowired
    private ThirdPartOrderDao thirdPartyOrderDao;

    @Override
    public List<Order> findByTid(Long tid) {
        return thirdPartyOrderDao.findByTid(tid);
    }
}
