package spring.boot.example.bootmarch.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.boot.example.bootmarch.domain.User;

@Repository("jdbcUserDao")
public class JdbcUserDao {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findUserList(){
		String sql = "select user_id, user_name,user_phone,score,create_time  from _user";
		List<User> userList=jdbcTemplate.query(sql, new RowMapper<User>() {
			User user;
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				user=new User();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setScore(rs.getString("score"));
				user.setCreate_time(rs.getString("create_time"));
				return user;
			}
		});
		return userList;
	}
	public  int addUser(User user) {
		String insertSql="INSERT INTO _user(user_name,user_phone,score,create_time) VALUES (?,?,?,SYSDATE())";
		int result=jdbcTemplate.update(insertSql, user.getUser_name(),user.getUser_phone(),user.getScore());
		return result;
	}
}
