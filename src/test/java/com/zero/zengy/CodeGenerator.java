package com.zero.zengy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    private static final String Author = "zengy";
    /**数据库连接字段配置**/
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/shop?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String JDBC_USER_NAME = "root";
    private static final String JDBC_PASSWORD = "123456";
    /**包名和模块名配置**/
    private static final String PACKAGE_NAME = "com.zero.zengy"; //包名
    private static final String MODULE_NAME = ""; //模块名
    /**相关路径配置**/
    private static final String projectPath = System.getProperty("user.dir");//项目地址
    private static final String OUT_FILE_PATH =projectPath +"/"+MODULE_NAME+"/src/main/java";//生成文件存放路径(可根据需要指定生成到某个模块下)
    /**相关模式开关**/
    private static final boolean IF_RECOVER_ENABLE = true; //再次调用时是否覆盖原文件
    private static final boolean IF_OPEN_DIRECTORY = false; //是否打开输出目录 默认值:true
    private static final boolean IF_SWAGGER2 = true; //是否开启swagger2模式 实体属性 Swagger2 注解
    private static final boolean IF_BASE_COLUMN_LIST = false; //开启 baseColumnList (通用查询结果列)，默认false,开启后mapper.xml文件中将生成对应代码
    private static final boolean IF_BASE_COLUMN_MAP = false; //开启 BaseResultMap (通用查询映射结果)，默认false,开启后mapper.xml文件中将生成对应代码
    private static final boolean IF_ACTIVE_RECORD = true; //开启ActiveRecord模式,默认false,参考：https://blog.csdn.net/qq_31762741/article/details/120392656
    private static final boolean IF_ENABLE_CACHE = false; // 是否在xml中添加二级缓存配置,默认false
    /**表设置**/
    private static final String TABLE_PREFIX = "_";  //表名的前缀,从表生成代码时会去掉前缀，没有前缀就只写_
    /**模版设置**/
    private static final  String templatePath = "/templates/mapper.xml.ftl";// 如果模板引擎是 freemarker
    //private static final String templatePath = "/templates/mapper.xml.vm";// 如果模板引擎是 velocity
    private static final  String Controller_template = "templates/controller.java";
    private static final  String Service_template = "templates/service.java";
    private static final  String ServiceImpl_template = "templates/serviceImpl.java";

    /**
     * <p>
     * 读取控制台内容 控制台输入模块表名回车自动生成对应项目目录中
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 主方法，包括（1.全局配置、2.数据源配置、3.包配置、4.自定义配置、5.模版配置、6.策略配置）
     * @param args
     */
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        GlobalConfig(gc,mpg);
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        DataSourceConfig(dsc,mpg);
        //包配置
        PackageConfig pc = new PackageConfig();
        PackageConfig(pc,mpg);
        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        InjectionConfig(cfg,mpg);
        //模版配置
        TemplateConfig templateConfig = new TemplateConfig();
        TemplateConfig(templateConfig,mpg);
        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        StrategyConfig(strategy,pc,mpg);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    // 全局配置
    private static AutoGenerator GlobalConfig(GlobalConfig gc,AutoGenerator mpg){
        gc.setFileOverride(IF_RECOVER_ENABLE);//再次调用时是否覆盖原文件
        gc.setOutputDir(OUT_FILE_PATH);
        gc.setAuthor(Author);
        gc.setOpen(IF_OPEN_DIRECTORY); //是否打开输出目录 默认值:true
        gc.setSwagger2(IF_SWAGGER2); //是否开启swagger2模式 实体属性 Swagger2 注解
        gc.setBaseColumnList(IF_BASE_COLUMN_LIST); //开启 baseColumnList (通用查询结果列)，默认false
        gc.setBaseResultMap(IF_BASE_COLUMN_MAP); //开启 BaseResultMap (通用查询映射结果)，默认false
        gc.setActiveRecord(IF_ACTIVE_RECORD); //开启ActiveRecord模式,默认false
        gc.setEnableCache(IF_ENABLE_CACHE); // 是否在xml中添加二级缓存配置,默认false
        gc.setIdType(IdType.AUTO);// AUTO(0)使用数据库id，NONE(1)不设置id生成策略，INPUT(2)用户手工输入id，ASSIGN_ID(3)雪花算法生成id(可兼容数值型与字符串型)，ASSIGN_UUID(4)以UUID生成算法作为id生成策略
        // 自定义文件命名，注意 %s 会自动填充表实体属性(各层文件名称方式，例如：%sAction生成UserAction, %s为占位符)
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        //gc.setEntityName("%sEntity");
        mpg.setGlobalConfig(gc);
        return mpg;
    }
    //数据源配置
    private static AutoGenerator DataSourceConfig(DataSourceConfig dsc,AutoGenerator mpg){
        dsc.setUrl(JDBC_URL);
        //dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(JDBC_USER_NAME);
        dsc.setPassword(JDBC_PASSWORD);
        mpg.setDataSource(dsc);
        return mpg;
    }
    //包配置
    private static AutoGenerator PackageConfig(PackageConfig pc,AutoGenerator mpg){
        //pc.setModuleName(scanner("模块名"));
        pc.setModuleName(MODULE_NAME);
        //你的项目包结构名
        pc.setParent(PACKAGE_NAME);
        mpg.setPackageInfo(pc);
        return mpg;
    }
    //自定义配置
    private static AutoGenerator InjectionConfig(InjectionConfig cfg ,AutoGenerator mpg){
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化
                // 注意此处要想生效，需要在模版设置中将XML设置为null,使默认的xml目录不再生成
                return projectPath +"/"+ MODULE_NAME + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        return mpg;
    }
    //模版配置
    private static AutoGenerator TemplateConfig(TemplateConfig templateConfig,AutoGenerator mpg){
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController(Controller_template);
        templateConfig.setService(Service_template);
        templateConfig.setServiceImpl(ServiceImpl_template);
//        templateConfig.setMapper("templates/vm/mapper.java");
//        templateConfig.setEntity("templates/vm/entity.java");
//        templateConfig.setXml("templates/vm/mapper.xml");
        //使默认的xml目录不再生成,使用自定义的resource/mapper输出目录
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        return mpg;
    }
    //策略配置
    private static AutoGenerator StrategyConfig(StrategyConfig strategy,PackageConfig pc,AutoGenerator mpg){
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);//restful api风格控制器
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 自动填充
        TableFill createTime = new TableFill("create_Time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_Time",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

        // 写于父类中的公共字段
        // strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //生成实体类等时去掉表前缀
        strategy.setTablePrefix(TABLE_PREFIX);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        return mpg;
    }

}