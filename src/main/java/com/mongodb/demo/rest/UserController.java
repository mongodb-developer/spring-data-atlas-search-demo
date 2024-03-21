package com.mongodb.demo.rest;

import com.mongodb.demo.entities.Address;
import com.mongodb.demo.entities.SimpleFacet;
import com.mongodb.demo.entities.User;
import com.mongodb.demo.repo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("users/byName")
    public List<User> getUsersByName(@RequestParam String name, @RequestParam(required = false, defaultValue = "10") int limit) {
         return userService.getUsersByName(name, limit);
    }

    @GetMapping("users/aggregated/byCity")
    public List<SimpleFacet> getUsersByCity() {
        return userService.usersByCity();
    }

    @GetMapping("users/search")
    public List<User> searchUsersByName(@RequestParam String query, @RequestParam(required = false, defaultValue = "10") int limit) {
        return userService.searchUsersByName(query.split(" "), limit);
    }

    @GetMapping("addresses/search")
    public List<Address> searchAddresses(@RequestParam String query, @RequestParam(required = false, defaultValue = "10") int limit) {
        return userService.searchAddresses(query.split(" "), limit);
    }


}
