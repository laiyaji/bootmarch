package spring.boot.example.bootmarch.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.example.bootmarch.domain.User;
import spring.boot.example.bootmarch.jdbc.dao.JdbcUserDao;

@Service("jdbcUserService")
public class JdbcUserService {

	@Autowired
	private JdbcUserDao jdbcUserDao;
	
	public List<User> findUserList(){
		return jdbcUserDao.findUserList();
	}
	
	public int addUser(User user) {
		return jdbcUserDao.addUser(user);
	}
}
