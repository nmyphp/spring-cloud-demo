package com.free.spring.jdbc.demo.common;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * 使用通用的CommonCondition替代
 */
@Deprecated
public class DefaultCondition extends ParentCondition implements Condition  {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        // 获取接口的名称
        String interfaceName = getInterFaceName(annotatedTypeMetadata);
        // 获取配置规则
        String implPrefix = environment.getProperty(interfaceName);
        if (StringUtils.isEmpty(implPrefix)) {
            return true;
        }
        return Constant.DEFAULT_PREFIX.equals(implPrefix);
    }
}
