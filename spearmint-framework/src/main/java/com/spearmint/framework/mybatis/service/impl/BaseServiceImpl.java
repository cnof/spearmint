package com.spearmint.framework.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spearmint.framework.mybatis.mapper.Mapper;
import com.spearmint.framework.mybatis.pojo.CommonEntity;
import com.spearmint.framework.mybatis.service.BaseService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 33992
 * @date 2019/1/29 11:39
 */
public class BaseServiceImpl<M extends Mapper<T>, T extends CommonEntity> extends ServiceImpl<M, T>
        implements BaseService<T> {

    @Override
    public Boolean insertSelective(T record) {
        record.setCreateDate(new Date());
        return save(record);
    }

    @Override
    public Boolean updateSelective(T record) {
        record.setModifyDate(new Date());
        return saveOrUpdate(record);
    }

    @Override
    public Boolean removeByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        return removeByIds(idList);
    }
}
