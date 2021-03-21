package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.house.pojo.HouseResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author lfqtm
 * @date 2021/3/20 下午6:10
 */
@RestController
@RequestMapping("house/resource")
@Api(value = "房源管理")
public class HouseResourcesController {
    @Autowired
    private HouseResourcesService houseResourcesService;

    @ApiOperation(value = "保存房源信息")
    @PostMapping
    public ResponseEntity<Void> save(@ApiParam(name = "houseResource", value = "房源", required = true) @RequestBody HouseResource houseResource) {
        try {
            boolean bool = this.houseResourcesService.save(houseResource);
            if (bool) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "测试接口")
    @GetMapping
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("ok");
    }
}
