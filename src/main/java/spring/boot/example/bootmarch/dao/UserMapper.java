package spring.boot.example.bootmarch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.boot.example.bootmarch.domain.User;

@Repository("userMapper")
public interface UserMapper {
 List<User> findUserList();
 int addUser(User user);
}
