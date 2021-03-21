package cn.itacst.haoke.dubbo.house.service.impl;

import cn.itcast.haoke.dubbo.house.pojo.BasePojo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author lfqtm
 * @date 2021/3/20 下午2:09
 */
public abstract class BaseServiceImpl<T extends BasePojo> {
    @Autowired
    private BaseMapper<T> mapper;

    /**
     * get data by id
     *
     * @param id id
     * @return data
     */
    public T queryById(Long id) {
        return this.mapper.selectById(id);
    }

    /**
     * get all data
     *
     * @return list
     */
    public List<T> queryAll() {
        return this.mapper.selectList(null);
    }

    /**
     * condition query
     * @param record condition
     * @return data
     */
    public T queryOne(T record) {
        return this.mapper.selectOne(new QueryWrapper<>(record));
    }

    /**
     * page query
     * @param record
     * @param page
     * @param rows
     * @return
     */
    public IPage<T> queryPageListByWhere(T record, Integer page, Integer rows) {
        return this.mapper.selectPage(new Page<T>(page, rows), new QueryWrapper<>(record));
    }

    /**
     * update record
     * @param record
     * @return
     */
    public Integer save(T record) {
        record.setUpdated(new Date());
        return this.mapper.updateById(record);
    }

    /**
     * delete data
     * @param id
     * @return
     */
    public Integer deleteById(String id) {
        return this.mapper.deleteById(id);
    }


    /**
     * delete batch
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Long> ids) {
        return this.mapper.deleteBatchIds(ids);
    }

    /**
     * delete by condition
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {
       return this.mapper.delete(new QueryWrapper<>(record));
    }
}
















