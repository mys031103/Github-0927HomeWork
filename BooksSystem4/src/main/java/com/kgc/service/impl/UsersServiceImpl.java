package com.kgc.service.impl;

import com.kgc.mapper.UsersMapper;
import com.kgc.pojo.Users;
import com.kgc.pojo.UsersExample;
import com.kgc.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;
    @Override
    public Users login(String userCode) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
        List<Users> users = usersMapper.selectByExample(example);
        if(users.size()>0){
            return users.get(0);
        }
        return null;
    }
}
