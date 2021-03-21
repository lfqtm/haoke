package cn.itacst.haoke.dubbo.house.service.impl;

import cn.itacst.haoke.dubbo.house.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.house.pojo.HouseResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lfqtm
 * @date 2021/3/20 下午2:20
 */
@Service
@Transactional
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResource> implements HouseResourcesService {

    @Override
    public int saveHouseResources(HouseResource houseResource) {
        if (StringUtils.isBlank(houseResource.getTitle())) {
            return -1;
        }
        //其他校验
        return super.save(houseResource);
    }
}
