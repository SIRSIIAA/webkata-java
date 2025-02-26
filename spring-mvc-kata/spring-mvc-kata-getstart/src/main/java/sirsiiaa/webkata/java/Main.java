package sirsiiaa.webkata.java;

public class Main {
    /*
     * Step1 导入3项主要依赖，spring-context、spring-webmvc、servlet-api(provided)
     * Step2 使用JBL插件将模块转化为JavaWeb工程
     * Step3 编写Controller及spring配置文件，配置adapter、mapper、包扫描
     * Step4 调整web.xml，注册dispatcherServlet及其init参数、提前启动
     *  1. 拦截所有请求 /
     *  2. 指定IoC配置文件
     *  3. 提前启动
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}