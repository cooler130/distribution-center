package com.cooler.ai.platform.service.impl;

import com.cooler.ai.platform.facade.DMFacade;
import com.cooler.ai.platform.service.DMFacadeMapService;

import java.util.Map;

public class XmlDMFacadeMapServiceImpl implements DMFacadeMapService {

    private Map<String, DMFacade> dmFacadeMap;

    public Map<String, DMFacade> getDmFacadeMap() {
        return dmFacadeMap;
    }

    public void setDmFacadeMap(Map<String, DMFacade> dmFacadeMap) {
        this.dmFacadeMap = dmFacadeMap;
    }

    @Override
    public DMFacade getFacadeName(String domainName) {
        return dmFacadeMap.get(domainName);
    }
}
