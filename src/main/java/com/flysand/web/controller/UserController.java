package com.flysand.web.controller;

import com.flysand.model.common.BooleanValue;
import com.flysand.model.entity.TUser;
import com.flysand.model.type.ErrorMsg;
import com.flysand.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by flysand on 2017年3月30日 0030.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;



    /**
     * 增加用户
     *
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BooleanValue addUser(@RequestParam String username) {

        logger.info("add user begin");
        BooleanValue bool = new BooleanValue();
        int uid = userService.addUser(username);
        if (uid > 0) {
            bool.setValue(true);
        } else {
            bool.setValue(false);
        }
        logger.info("add user end");
        return bool;
    }

    @ResponseBody
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<TUser> getUsers(int pageIndex, int pageSize) {

        return userService.getUsers(pageIndex,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/addMOUser",method = RequestMethod.POST)
    public BooleanValue addMOUser(String username,String password){
        BooleanValue booleanValue = new BooleanValue();
        int result = userService.addMOUser(username,password);
        if(result>0){
            booleanValue.setValue(true);
        }else {
            booleanValue.setValue(false);
        }
        return booleanValue;
    }

    /**
     * 用户登录，写这个方法的目的主要是为了测https时是不是登录的信息在页面上不显示，结果发现https其实就是加一个证书，意思就是有证书的人就是信任授权的人
     * 可以跟一般的http请求一样进行操作，加了https的意义在于外部攻击人员，无法知道证书内容因此无法查看传输数据
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ErrorMsg login(@RequestParam String username,@RequestParam String password){
        logger.debug("username "+ username + " login");
        return userService.login(username,password);
    }

}
