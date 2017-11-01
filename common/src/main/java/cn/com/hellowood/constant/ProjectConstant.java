package cn.com.hellowood.constant;

/**
 * @author HelloWood
 **/
public class ProjectConstant {

    public static final String BASE_PACKAGE = "cn.com.hellowood";//项目基础包名

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model.entity";// Model实体包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";// Mapper包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";// Service包
    public static final String SERVICE_IMPL_PACKAGE = BASE_PACKAGE + ".service.impl";// ServiceImpl包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";// Controller包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";// Mapper插件基础接口的完全限定名
}
