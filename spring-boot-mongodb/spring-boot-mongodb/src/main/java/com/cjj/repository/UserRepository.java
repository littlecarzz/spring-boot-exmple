package com.cjj.repository;

import com.cjj.model.User;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/22 15:18
 */
public interface UserRepository {
    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public long updateUser(User user);

    public void deleteUserById(Long id);
}
