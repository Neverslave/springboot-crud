package com.yuedanet.service;

import com.yuedanet.pojo.User;

import java.util.List;

public interface UserService {
    void saveUser(User user)throws Exception;
    void updateUser(User user);
    void deleteUser(Integer userid);
    User queryUserById(Integer userid);
    List<User> querUserList(User user);
    List<User> queryUserListPaged(User user,Integer page,Integer pageSize);

}
