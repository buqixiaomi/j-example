package cn.buqixiaomi.demo.controller;

import cn.buqixiaomi.demo.entity.Log;
import cn.buqixiaomi.demo.entity.User;
import cn.buqixiaomi.demo.mapper.LogMapper;
import cn.buqixiaomi.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author lishengkai
 * @date 2019-01-08 18:12
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LogMapper logMapper;

    @RequestMapping("adduser")
    public Integer addUser(){
        User user = new User();
        user.setUserName("sdfsdf");
        user.setOperStatus((byte)0);
        user.setOperTime(System.currentTimeMillis());
        return userMapper.insert(user);
    }

    @RequestMapping("addlog")
    public Integer addLog(){
        Log log = new Log();
        log.setMemo("ddddd");
        return logMapper.insert(log);
    }
}
