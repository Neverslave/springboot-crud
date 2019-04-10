package com.yuedanet.mapper;

import com.yuedanet.pojo.User;
import com.yuedanet.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperCustom extends MyMapper<User> {
    List<User> queryUserSimplyInfoById(Integer id);
}