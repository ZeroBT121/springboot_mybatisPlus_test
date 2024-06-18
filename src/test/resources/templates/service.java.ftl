package ${package.Service};
import com.zero.zengy.common.Result;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
* <p>
    * ${table.comment!} 服务类
    * </p>
*/
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

/**
* 新增数据
*
* @param ${"${entity}"} 实体对象
* @return Result
*/
Result<?> ${"add${entity}"}(${"${entity}"} ${"${entity?uncap_first}"});

/**
* 根据ID查询数据
*
* @param id ID
* @return Result
*/
Result<?> ${"get${entity}ById(Long id)"};

/**
* 更新数据
*
* @param ${entity?uncap_first} 实体对象
* @return Result
*/
Result<?> ${"update${entity}"}(${entity} ${entity?uncap_first});

/**
* 删除数据
*
* @param id ID
* @return Result
*/
Result<?> ${"delete${entity}"}(Long id);

}