package com.kgc.springssm.service.impl;

import com.kgc.springssm.mapper.UsersMapper;
import com.kgc.springssm.pojo.Users;
import com.kgc.springssm.pojo.UsersExample;
import com.kgc.springssm.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 13:55
 */
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    UsersMapper usersMapper;
    @Override
    public Users login(String userCode) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
        List<Users> list = usersMapper.selectByExample(example);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
