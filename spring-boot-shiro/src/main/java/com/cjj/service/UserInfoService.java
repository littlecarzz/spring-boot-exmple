package com.cjj.service;

import com.cjj.model.UserInfo;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/23 14:14
 */
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
