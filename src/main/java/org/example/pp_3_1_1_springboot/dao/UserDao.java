package org.example.pp_3_1_1_springboot.dao;

import org.example.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getByIdUser(Long id);

    void save(User user);

    void update(Long id, User updateUser);

    void delete(Long id);
}