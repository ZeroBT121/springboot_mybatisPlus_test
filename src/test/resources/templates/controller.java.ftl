package ${package.Controller};

import org.springframework.beans.factory.annotation.Autowired;
import com.zero.zengy.common.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};


/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*/
@Slf4j
@Api(value = "${entity}", tags = "${entity}")
@RestController
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} {

@Autowired
private ${table.serviceName} ${table.serviceName?uncap_first};

/**
* 新增数据
*
* @param ${entity?uncap_first} 实体对象
* @return Result
*/
@PostMapping("add")
@ResponseBody
public Result<?> add(@Validated @RequestBody ${entity} ${entity?uncap_first}) {
return ${table.serviceName?uncap_first}.add${entity}(${entity?uncap_first});
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
if(id!=null){
return ${table.serviceName?uncap_first}.get${entity}ById(id);
}
return Result.fail(500, "操作失败");
}

/**
* 更新数据
*
* @param ${entity?uncap_first} 实体对象
* @return Result
*/
@PostMapping("update")
@ResponseBody
public Result<?> update(@Validated @RequestBody ${entity} ${entity?uncap_first}) {
if(${entity?uncap_first}.getId()!=null){
return ${table.serviceName?uncap_first}.update${entity}(${entity?uncap_first});
}
return Result.fail(500, "操作失败");
}

/**
* 删除数据
*
* @param id ID
* @return Result
*/
@PostMapping("delete/{id}")
@ResponseBody
public Result<?> delete(@PathVariable Long id) {
if(id!=null){
return ${table.serviceName?uncap_first}.delete${entity}(id);
}
return Result.fail(500, "操作失败");
}

}