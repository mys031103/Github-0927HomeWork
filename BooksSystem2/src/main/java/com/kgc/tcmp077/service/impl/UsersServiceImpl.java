package com.kgc.tcmp077.service.impl;

import com.kgc.tcmp077.mapper.UsersMapper;
import com.kgc.tcmp077.pojo.Users;
import com.kgc.tcmp077.pojo.UsersExample;
import com.kgc.tcmp077.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-27 21:21
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;
    @Override
    public Users users(String userCode) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if(users.size()>0){
            return users.get(0);
        }
        return null;
    }
}
