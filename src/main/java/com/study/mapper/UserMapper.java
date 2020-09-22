package com.study.mapper;

import com.study.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yuminjun yuminjun@lexiangbao.com
 * @version 1.00
 * @date 2020/9/22 13:53
 * @record <pre>
 * version  author      date      desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/9/22   新建
 * -------------------------------------------------
 * </pre>
 */
@Mapper
public interface UserMapper {

//    @Select("SELECT id, name, age FROM user LIMIT 10")
    List<User> selectUser();

}
