package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.Intent;
import org.apache.ibatis.annotations.Param;

public interface IntentMapper {

    Intent selectByIntentId(@Param("intentId") Integer intentId);

    Intent selectByTwoNames(@Param("domainName") String domainName, @Param("intentName")String intentName);
}