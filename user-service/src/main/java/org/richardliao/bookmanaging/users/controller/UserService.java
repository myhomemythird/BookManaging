package org.richardliao.bookmanaging.users.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.richardliao.bookmanaging.users.domain.User;
import org.richardliao.bookmanaging.users.mapper.UserMapper;
import org.richardliao.bookmanaging.users.CommonResponce;

@RestController
@RequestMapping(value="/library", produces="application/json")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/users", method=GET)
    public Object userList(@QueryParam("account") String account, @QueryParam("roleId") String roleId) {
        Map<String, String> query = new HashMap<>();
	if (null != account && !"".equals(account.trim())) query.put("account", account);
	if (null != roleId && !"".equals(roleId.trim())) query.put("roleId", roleId);
	List<User> res = userMapper.getUserList(query);
	return new CommonResponce(0, res);
    }

    @RequestMapping(value="/user/{id}", method=GET)
    public Object userDetail(@PathVariable("id") String id) {
        User res = userMapper.getUserById(id);
	return new CommonResponce(0, res);
    }

    @RequestMapping(value="/user", method=POST)
    public Object addUser(@RequestBody User user) {
	if (null == user)
	    return new CommonResponce(1, "Failed. User is null!");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String id = sdf.format(new Date()) + getRandomString(12);
	user.setId(id);
	userMapper.add(user);
	return new CommonResponce(0, user);
    }

    @RequestMapping(value="/user", method=PUT)
    public Object updateUser(@RequestBody User user) {
	if (null == user || null == user.getId())
	    return new CommonResponce(1, "Failed. User or User.id is null!");
	User userDb = userMapper.getUserById(user.getId());
	if (null == userDb) return new CommonResponce(1, "Failed. No User [" + user.getId() + "] found!");
	userMapper.update(user);
	return new CommonResponce(0, user);
    }

    @RequestMapping(value="/user/{id}", method=DELETE)
    public Object deleteUser(@PathVariable("id") String id) {
        User userDb = userMapper.getUserById(id);
        if (null == userDb) return new CommonResponce(1, "Failed. No User [" + id + "] found!");
	userMapper.delete(id);
	return new CommonResponce(0, userDb);
    }

    private static String getRandomString(int length) { //length表示生成字符串的长度
	String base = "abcdefghijklmnopqrstuvwxyz0123456789";  
	Random random = new Random();  
	StringBuffer sb = new StringBuffer();  
	for (int i = 0; i < length; i++) {  
	    int number = random.nextInt(base.length());  
	    sb.append(base.charAt(number));  
	}  
	return sb.toString();  
    } 
}
