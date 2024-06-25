package com.zero.zengy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.zero.zengy.common.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import com.zero.zengy.entity.Addresses;
import com.zero.zengy.service.AddressesService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 */
@Slf4j
@Api(value = "Addresses", tags = "Addresses")
@RestController
@RequestMapping("/addresses")
public class AddressesController {

    @Autowired
    private AddressesService addressesService;

    /**
     * 新增数据
     *
     * @param addresses 实体对象
     * @return Result
     */
    @PostMapping("add")
    @ResponseBody
    public Result<?> add(@Validated @RequestBody Addresses addresses) {
        return addressesService.addAddresses(addresses);
    }

    /**
     * 根据ID查询数据
     *
     * @param id ID
     * @return Result
     */
    @GetMapping("getById/{id}")
    @ResponseBody
    public Result<?> getById(@PathVariable Long id) {
        if (id != null) {
            return addressesService.getAddressesById(id);
        }
        return Result.fail(500, "操作失败");
    }

    /**
     * 更新数据
     *
     * @param addresses 实体对象
     * @return Result
     */
    @PostMapping("update")
    @ResponseBody
    public Result<?> update(@Validated @RequestBody Addresses addresses) {
        if (addresses.getAddressId() != null) {
            return addressesService.updateAddresses(addresses);
        }
        return Result.fail(500, "操作失败");
    }

    /**
     * 删除数据
     *
     * @param id ID
     * @return Result
     */
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public Result<?> delete(@PathVariable Long id) {
        if (id != null) {
            return addressesService.deleteAddresses(id);
        }
        return Result.fail(500, "操作失败");
    }


    /**
     * 获取所有地址列表，支持分页。
     *
     * @param pageNum  当前页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 分页后的地址列表
     */
    @GetMapping("listAll")
    @ResponseBody
    public Result<List<Addresses>> listAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return addressesService.getAllAddresses(pageNum, pageSize);
    }
}
