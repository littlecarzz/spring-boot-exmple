package com.cjj.service.impl;

import com.cjj.dao.UserInfoDao;
import com.cjj.model.UserInfo;
import com.cjj.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/23 14:15
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
