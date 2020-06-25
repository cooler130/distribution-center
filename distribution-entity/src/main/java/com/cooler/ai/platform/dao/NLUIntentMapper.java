package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.NLUIntent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NLUIntentMapper {

    NLUIntent selectByTwoNames(@Param("nluIntentName") String nluIntentName, @Param("nluDomainName") String nluDomainName);

    List<NLUIntent> selectByIntentName(@Param("nluIntentName") String nluIntentName);
}