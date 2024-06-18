package com.zero.zengy.service;
import com.zero.zengy.common.Result;
import com.zero.zengy.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* <p>
    *  服务类
    * </p>
*/
public interface UsersService extends IService<Users> {

/**
* 新增数据
*
* @param Users 实体对象
* @return Result
*/
Result<?> addUsers(Users users);

/**
* 根据ID查询数据
*
* @param id ID
* @return Result
*/
Result<?> getUsersById(Long id);

/**
* 更新数据
*
* @param users 实体对象
* @return Result
*/
Result<?> updateUsers(Users users);

/**
* 删除数据
*
* @param id ID
* @return Result
*/
Result<?> deleteUsers(Long id);

}