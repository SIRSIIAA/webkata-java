package sirsiiaa.webkata.java.pojo;

import lombok.Data;

/*
 * 使用@ToString自动生成toString方法
 */
@Data // 等同于getter、setter、toString、无参构造函数
public class User {
    /*
     * 使用lombok可以简化getter、setter的操作
     * @Getter标记字段以自动生成getter方法
     * @Setter标记字段以自动生成setter方法
     */
    private String name;
    private Integer age;

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "name: " + name + ", age: " + age;
//    }
}
