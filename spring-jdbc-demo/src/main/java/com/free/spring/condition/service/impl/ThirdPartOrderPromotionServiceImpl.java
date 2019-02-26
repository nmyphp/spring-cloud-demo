package com.free.spring.condition.service.impl;

import com.free.spring.condition.dao.ThirdPartOrderPromotionDao;
import com.free.spring.jdbc.demo.common.CommonCondition;
import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import com.free.spring.jdbc.demo.service.OrderPromotionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional(CommonCondition.class)
@Service
public class ThirdPartOrderPromotionServiceImpl implements OrderPromotionService {

    @Autowired
    private ThirdPartOrderPromotionDao thirdPartyOrderPromotionDao;

    @Override
    public List<OrderPromotion> findByTid(Long tid) {
        return thirdPartyOrderPromotionDao.findByTid(tid);
    }
}
