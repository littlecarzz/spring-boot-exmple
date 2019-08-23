package com.cjj.dao;

import com.cjj.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/23 14:16
 */
//@Component
public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
