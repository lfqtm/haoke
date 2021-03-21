package cn.itacst.haoke.dubbo.house.api;

import cn.itacst.haoke.dubbo.house.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.house.api.ApiHouseResourcesService;
import cn.itcast.haoke.dubbo.house.pojo.HouseResource;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lfqtm
 * @date 2021/3/20 下午2:23
 */
@Service(version = "1.0.0")
public class ApiHouseResourcesImpl implements ApiHouseResourcesService {
    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResource houseResource) {
        return this.houseResourcesService.saveHouseResources(houseResource);
    }
}
