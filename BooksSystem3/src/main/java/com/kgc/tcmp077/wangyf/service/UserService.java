package com.kgc.tcmp077.wangyf.service;

import com.kgc.tcmp077.wangyf.entity.Users;

import java.util.List;

/**
 * @author wangyf
 * @create 2020-09-27 21:42
 */
public interface UserService {
    List<Users> selectByUserCode(String userCode);
}
