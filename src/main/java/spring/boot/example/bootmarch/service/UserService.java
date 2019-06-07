package spring.boot.example.bootmarch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.example.bootmarch.dao.UserMapper;
import spring.boot.example.bootmarch.domain.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findUserList(){
		return userMapper.findUserList();
	}
	public  int addUser(User user) {
		return userMapper.addUser(user);
	}
}
