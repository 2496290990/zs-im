package com.eleven.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhaojinhui
 * @date 2021/2/21 16:35
 * @apiNote
 */
public class GenApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. 创建代码生成器
        AutoGenerator autoGen = new AutoGenerator();
        //2. 全局配置
        GlobalConfig gc = new GlobalConfig();
        System.out.println("请输入要生成的项目目录");
        //获取当前项目的路径
        String projectPath = System.getProperty("user.dir") + File.separator;
        String modelName = scanner.nextLine();
        projectPath += modelName;
        //生成的文件输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置作者
        gc.setAuthor("eleven");
        //是否打开资源管理器
        gc.setOpen(false);
        //重新生成文件是否覆盖
        gc.setFileOverride(true);
        //设置主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        //设置去除自动生成的Service首字母I
        gc.setServiceName("%sService");
        //设置日期类型
        gc.setDateType(DateType.ONLY_DATE);
        //设置是否打开Swagger
        gc.setSwagger2(true);



        autoGen.setGlobalConfig(gc);

        //3.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql:///zs_im?serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("dream");

        autoGen.setDataSource(dsc);

        //4.生成的包配置
        PackageConfig pc = new PackageConfig();
        //设置模块名
        //pc.setModuleName(modelName);
        pc.setParent("com.im");
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("mapper.xml");

        autoGen.setPackageInfo(pc);

        //5. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //需要生成的表名
        strategy.setInclude("im_" + "\\w*");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix("im_");
        //自动添加 lombok的注解
        strategy.setEntityLombokModel(true);
        //逻辑删除字段
        strategy.setLogicDeleteFieldName("del_flag");
        //去除布尔值的 is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        //自动填充
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        Collections.addAll(tableFills, createTime,updateTime);
        strategy.setTableFillList(tableFills);
        //设置 Restful 风格的请求
        strategy.setRestControllerStyle(true);
        //url 驼峰命名转换成 _
        //strategy.setControllerMappingHyphenStyle(true);
        autoGen.setStrategy(strategy);

        //6.执行
        autoGen.execute();
    }
}
