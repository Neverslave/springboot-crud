package com.yuedanet.mapper;

import com.yuedanet.pojo.User;
import com.yuedanet.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}