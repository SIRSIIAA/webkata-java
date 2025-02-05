package sirsiiaa.webkata.java.druid;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidDemo {
    public static void main(String[] args) {
        var url = "jdbc:mysql:///delivery_system";
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(url);
        ds.setUsername("root");
        ds.setPassword("123456");
    }
}
