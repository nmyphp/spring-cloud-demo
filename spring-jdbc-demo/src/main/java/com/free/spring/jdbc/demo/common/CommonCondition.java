package com.free.spring.jdbc.demo.common;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.util.StringUtils;

public class CommonCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String className = null;
        if (metadata instanceof ClassMetadata) {
            // 获取实现类的名称
            className = ((ClassMetadata) metadata).getClassName();
        }

        String interFaceName = getInterFaceName(metadata);
        // 通过接口名称查询配置
        String classNameByConf = context.getEnvironment().getProperty(interFaceName);
        return StringUtils.isEmpty(classNameByConf) || classNameByConf.equals(className);
    }

    /**
     * 获取实现的接口的名称
     */
    protected String getInterFaceName(AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (annotatedTypeMetadata instanceof ClassMetadata) {
            String[] interfaceNames = ((ClassMetadata) annotatedTypeMetadata).getInterfaceNames();
            if (interfaceNames.length > 0) {
                return interfaceNames[0];
            }
        }

        return ((MethodMetadata)annotatedTypeMetadata).getDeclaringClassName();
    }
}
