package com.cjj.mapper;

import com.cjj.enums.UserSexEnum;
import com.cjj.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/20 16:44
 */
public interface UserMapper {


    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
