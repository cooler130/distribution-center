package com.cooler.ai.platform.service.impl.entity;

import com.cooler.ai.platform.dao.NLUIntentMapper;
import com.cooler.ai.platform.entity.NLUIntent;
import com.cooler.ai.platform.service.entity.NLUIntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangsheng on 2018/6/20.
 */
@Service("nluIntentService")
public class NLUIntentServiceImpl implements NLUIntentService {

    @Autowired
    private NLUIntentMapper nluIntentMapper;

    @Override
    public NLUIntent selectByTwoNames(String nluIntentName, String nluDomainName) {
        return nluIntentMapper.selectByTwoNames(nluIntentName, nluDomainName);
    }

    @Override
    public List<NLUIntent> selectByIntentName(String nluIntentName) {
        return nluIntentMapper.selectByIntentName(nluIntentName);
    }
}
