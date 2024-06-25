package com.zero.zengy.service.impl;

import com.zero.zengy.entity.Users;
import com.zero.zengy.mapper.UsersMapper;
import com.zero.zengy.service.UsersService;
import com.zero.zengy.common.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 新增数据
     *
     * @param users 实体对象
     * @return Result
     */
    @Override
    public Result<?> addUsers(Users users) {
        return Result.success(usersMapper.insert(users));
    }

    /**
     * 根据ID查询数据
     *
     * @param id ID
     * @return responseResult
     */
    @Override
    public Result<?> getUsersById(Long id) {
        if (id == null) {
            return Result.fail(500,"ID不能为空");
        }
        Users users = usersMapper.selectById(id);
        if (users != null) {
            return Result.success(users);
        } else {
            return Result.fail(500, null);
        }
    }

    /**
     * 更新数据
     *
     * @param users 实体对象
     * @return Result
     */
    @Override
    public Result<?> updateUsers(Users users) {
        if (usersMapper.updateById(users) > 0) {
            return Result.success("更新成功");
        } else {
            return Result.fail(500, null);
        }
    }

    /**
     * 删除数据
     *
     * @param id ID
     * @return Result
     */
    @Override
    public Result<?> deleteUsers(Long id) {
        if (usersMapper.deleteById(id) > 0) {
            return Result.success("删除成功");
        } else {
            return Result.fail(500, null);
        }
    }
}