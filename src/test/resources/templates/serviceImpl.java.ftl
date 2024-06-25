package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import com.zero.zengy.common.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     ${table.comment!} 服务实现类
 * </p>
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} ${table.mapperName?uncap_first};

    /**
     * 新增数据
     *
     * @param ${entity?uncap_first} 实体对象
     * @return Result
     */
    @Override
    public Result add${entity}(${entity} ${entity?uncap_first}) {
        // 忽略不需要手动填入的属性插入，预防误填出错
        // CopyOptions options = CopyOptions.create()
        //         .setIgnoreProperties("createTime").setIgnoreProperties("updateTime")
        //         .setIgnoreProperties("createBy").setIgnoreProperties("updateBy");
        // BeanUtil.copyProperties(${entity?uncap_first}, ${entity?uncap_first}, options);
        return Result.success(${table.mapperName?uncap_first}.insert(${entity?uncap_first}));
    }

    /**
     * 根据ID查询数据
     *
     * @param id ID
     * @return responseResult
     */
    @Override
    public Result get${entity}ById(Long id) {
        ${entity} ${entity?uncap_first} = ${table.mapperName?uncap_first}.selectById(id);
        if (${entity?uncap_first} != null) {
            return Result.success(${entity?uncap_first});
        } else {
            return Result.fail(500, null);
        }
    }

    /**
     * 更新数据
     *
     * @param ${entity?uncap_first} 实体对象
     * @return Result
     */
    @Override
    public Result update${entity}(${entity} ${entity?uncap_first}) {
        if (${table.mapperName?uncap_first}.updateById(${entity?uncap_first}) > 0) {
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
    public Result delete${entity}(Long id) {
        if (${table.mapperName?uncap_first}.deleteById(id) > 0) {
            return Result.success("删除成功");
        } else {
            return Result.fail(500, null);
        }
    }
}