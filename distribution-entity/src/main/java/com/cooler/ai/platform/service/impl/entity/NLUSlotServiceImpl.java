package com.cooler.ai.platform.service.impl.entity;

import com.cooler.ai.platform.dao.NLUSlotMapper;
import com.cooler.ai.platform.entity.NLUSlot;
import com.cooler.ai.platform.service.entity.NLUSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by zhangsheng on 2018/6/20.
 */
@Service("nluSlotService")
public class NLUSlotServiceImpl implements NLUSlotService {

    @Autowired
    private NLUSlotMapper nluSlotMapper;


    @Override
    public List<NLUSlot> selectByIds(Set<Integer> ids) {
        return nluSlotMapper.selectByIds(ids);
    }
}
