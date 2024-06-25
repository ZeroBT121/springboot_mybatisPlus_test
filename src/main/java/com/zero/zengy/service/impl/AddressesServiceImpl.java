package com.zero.zengy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zero.zengy.entity.Addresses;
import com.zero.zengy.mapper.AddressesMapper;
import com.zero.zengy.service.AddressesService;
import com.zero.zengy.common.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *      服务实现类
 * </p>
 */
@Service
public class AddressesServiceImpl extends ServiceImpl<AddressesMapper, Addresses> implements AddressesService {

    @Autowired
    private AddressesMapper addressesMapper;

    /**
     * 新增数据
     *
     * @param addresses 实体对象
     * @return Result
     */
    @Override
    public Result addAddresses(Addresses addresses) {
        // 忽略不需要手动填入的属性插入，预防误填出错
        // CopyOptions options = CopyOptions.create()
        //         .setIgnoreProperties("createTime").setIgnoreProperties("updateTime")
        //         .setIgnoreProperties("createBy").setIgnoreProperties("updateBy");
        // BeanUtil.copyProperties(addresses, addresses, options);
        return Result.success(addressesMapper.insert(addresses));
    }

    /**
     * 根据ID查询数据
     *
     * @param id ID
     * @return responseResult
     */
    @Override
    public Result getAddressesById(Long id) {
        Addresses addresses = addressesMapper.selectById(id);
        if (addresses != null) {
            return Result.success(addresses);
        } else {
            return Result.fail(500, null);
        }
    }

    /**
     * 更新数据
     *
     * @param addresses 实体对象
     * @return Result
     */
    @Override
    public Result updateAddresses(Addresses addresses) {
        if (addressesMapper.updateById(addresses) > 0) {
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
    public Result deleteAddresses(Long id) {
        if (addressesMapper.deleteById(id) > 0) {
            return Result.success("删除成功");
        } else {
            return Result.fail(500, null);
        }
    }


    /**
     * 查询所有数据
     *
     */
    @Override
    public Result<List<Addresses>> getAllAddresses(int pageNum, int pageSize) {
        // 构造分页对象
        Page<Addresses> page = new Page<>(pageNum, pageSize);

        // 执行分页查询，addressesMapper.selectPage(page, null) 中的第二个参数可以传入条件对象，这里传入 null 表示查询所有
        List<Addresses> addressList = addressesMapper.selectPage(page, null).getRecords();

        // 构造返回结果，这里假设使用了 Result.success 方法返回成功结果
        return Result.success(addressList);
    }
}