package com.yuedanet.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.yuedanet.mapper.UserMapper;
import com.yuedanet.mapper.UserMapperCustom;
import com.yuedanet.pojo.User;
import com.yuedanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private UserMapperCustom userMapperCustom;
    @Override
    public void saveUser(User user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user); //有值才会更新
    }

    @Override
    public void deleteUser(Integer userid) {
        userMapper.deleteByPrimaryKey(userid);

    }

    @Override
    public User queryUserById(String userid) {
        return userMapper.selectByPrimaryKey(userid);
    }


    //分页显示
    @Override
    public List<User> queryUserListPaged(User user, Integer page, Integer pageSize) {
       //开始分页
        PageHelper.startPage(page,pageSize);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
//			criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }
        example.orderBy("createTime").desc();
        List<User> userList = userMapper.selectByExample(example);
                return userList;
    }

    @Override
    public List<User> querUserList(User user) {
        Example example = new Example(User.class);
       Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
//			criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }

        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }

        List<User> userList = userMapper.selectByExample(example);

        return userList;
    }

    public List<User> queryUserByIdCustom(Integer id){
        List<User> userList = userMapperCustom.queryUserSimplyInfoById(id);
        return userList;
    }

}
