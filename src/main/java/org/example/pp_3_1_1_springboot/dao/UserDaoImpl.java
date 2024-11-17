package org.example.pp_3_1_1_springboot.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.example.pp_3_1_1_springboot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return  entityManager.createQuery("from User" , User.class).getResultList();
    }

    public User getByIdUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(Long id, User updateUser) {
        User userToBeUpdate = getByIdUser(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}