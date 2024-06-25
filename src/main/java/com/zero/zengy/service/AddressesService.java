package com.zero.zengy.service;

import com.zero.zengy.common.Result;
import com.zero.zengy.entity.Addresses;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface AddressesService extends IService<Addresses> {
    /**
     * 新增数据
     *
     * @param addresses 实体对象
     * @return Result
     */
    Result<?> addAddresses(Addresses addresses);

    /**
     * 根据ID查询数据
     *
     * @param id ID
     * @return Result
     */
    Result<?> getAddressesById(Long id);

    /**
     * 更新数据
     *
     * @param addresses 实体对象
     * @return Result
     */
    Result<?> updateAddresses(Addresses addresses);

    /**
     * 删除数据
     *
     * @param id ID
     * @return Result
     */
    Result<?> deleteAddresses(Long id);

    /**
     * 查询所有数据
     *
     */
    Result<List<Addresses>> getAllAddresses(int pageNum, int pageSize);
}
