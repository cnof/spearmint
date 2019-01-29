package com.spearmint.framework.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spearmint.framework.mybatis.pojo.CommonEntity;

/**
 * @author 33992
 * @date 2019/1/29 11:30
 */
public interface BaseService<T extends CommonEntity> extends IService<T> {

    /**
     * 新增数据
     * @param record 数据
     * @return 是否成功
     */
    Boolean insertSelective(T record);

    /**
     * 更新数据
     * @param record 数据
     * @return 是否成功
     */
    Boolean updateSelective(T record);

    /**
     * 删除数据
     * @param ids 主键
     * @return 是否成功
     */
    Boolean removeByIds(String ids);
}
