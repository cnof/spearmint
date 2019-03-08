package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/1 19:40
 */
@Repository
public interface MenuMapper {

    /**
     * select menus by menuIds
     * @param menuIds primary key
     * @return menus
     */
    List<Menu> listMenusByMenuIds(@Param("menuIds") List<String> menuIds);
}
