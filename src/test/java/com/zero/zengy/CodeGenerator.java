package com.zero.zengy;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

//代码生成器
public class CodeGenerator {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        final String username="root";
        final String password="123456";

        List<String> tables = new ArrayList<>();
        //添加 表 到集合中，可以添加多个表
        tables.add("addresses");

        //全局配置
        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.author("zengy")  //作者
                            .disableOpenDir() // 允许自动打开输出目录
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java") //输出路径(java目录)
                            .enableSwagger()   //开启swagger，要引入依赖，注意版本是2.x
                            .commentDate("yyyy-MM-dd");
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.zero.zengy")
                            .moduleName("")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                //策略配置: 所谓策略配置，就是配置策略，配置细节
                .strategyConfig(builder -> {
                    //addInclude(表)就是指定为哪些表生成代码
                    builder.addInclude(tables)  //表明是通过哪个表生成的
                            .serviceBuilder()  //service生成策略配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder() //实体类生成策略配置
                            .enableLombok() //开启Lombok
                            .logicDeleteColumnName("deleted")//说明逻辑删除的字段是哪个
                            .enableTableFieldAnnotation() //开启属性上加上说明注解
                            .controllerBuilder()  //controller生成策略配置
                            // 映射路径使用连字符格式，而不是驼峰
//                           .enableHyphenStyle()
                            .formatFileName("%sController")
                            .enableRestStyle() //开启RestController生成策略配置
                            .mapperBuilder()  //mapper生成策略配置
                            //生成通用的resultMap
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)  //所有mapper类继承BaseMapper
//                           .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation() //开启@mapper注解
                            .formatXmlFileName("%sMapper");

                    new StrategyConfig.Builder()
                            .entityBuilder()
                            .enableLombok() //开启 lombok 模型
                            .versionPropertyName("version")  //乐观锁
                            .logicDeletePropertyName("deleted") //逻辑删除
//                           .naming()  //数据库表映射到实体的命名策略,默认下划线转驼峰命
                            .idType(IdType.AUTO) //全局主键类型
                            .addTableFills(new Property("createdAt", FieldFill.INSERT)) //字段填充
                            .addTableFills(new Property("updatedAt", FieldFill.INSERT_UPDATE));//属性填充
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();





    }
}