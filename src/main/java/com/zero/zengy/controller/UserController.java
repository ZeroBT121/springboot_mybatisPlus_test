package com.zero.zengy.controller;

import com.zero.zengy.common.Result;
import com.zero.zengy.entity.User;
import com.zero.zengy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public  User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByIdPro")
    public  Result getUserByIdPro(@RequestParam Long id){
        return Result.success(userService.getUserById(id));
    }

    // 新增用户
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        Boolean isSuccess = userService.addUser(user);
        return Result.success(isSuccess);
    }

    // 根据id删除用户。软删除
    @DeleteMapping("/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable Long id) {
        Boolean isSuccess = userService.deleteUserById(id);
        return Result.success(isSuccess);
    }
}
