package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.house.api.ApiHouseResourcesService;
import cn.itcast.haoke.dubbo.house.pojo.HouseResource;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author lfqtm
 * @date 2021/3/20 下午6:08
 */
@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResource houseResource) {
        int result = this.apiHouseResourcesService.saveHouseResources(houseResource);
        return result == 1;
    }
}
