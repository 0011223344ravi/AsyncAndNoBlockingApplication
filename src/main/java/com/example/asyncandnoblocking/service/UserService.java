package com.example.asyncandnoblocking.service;

import com.example.asyncandnoblocking.dao.UserDao;
import com.example.asyncandnoblocking.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        long start = System.currentTimeMillis();
       List<User> list=  userDao.getUsers();
        long end = System.currentTimeMillis();
        System.out.println("start time is " +start +"end time is  " +end +"total time taken "+(end - start));
       return list;
     }

    public Flux<User> getAllUsersStream(){
        long start = System.currentTimeMillis();
        Flux<User> fluxOfUsers=  userDao.getUsersStream();
        long end = System.currentTimeMillis();
        System.out.println("start time is " +start +"end time is  " +end +"total time taken "+(end - start));
         return fluxOfUsers;
    }
}
