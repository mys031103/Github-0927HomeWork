package com.kgc.tcmp077.wangyf.service.impl;

import com.kgc.tcmp077.wangyf.entity.Users;
import com.kgc.tcmp077.wangyf.entity.UsersExample;
import com.kgc.tcmp077.wangyf.mapper.UsersMapper;
import com.kgc.tcmp077.wangyf.service.UserService;
import javafx.scene.shape.Circle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangyf
 * @create 2020-09-27 21:43
 */
@Service("userService")
public class userServiceImpl implements UserService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public List<Users> selectByUserCode(String userCode) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if (userCode!=null) {
            criteria.andUserCodeEqualTo(userCode);
        }
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users;
    }
}
