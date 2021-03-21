package cn.itcast.haoke.dubbo.house.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lfqtm
 * @date 2021/3/19 下午11:04
 */
@Data
public abstract class BasePojo implements Serializable {
    private Date created;
    private Date updated;
}
