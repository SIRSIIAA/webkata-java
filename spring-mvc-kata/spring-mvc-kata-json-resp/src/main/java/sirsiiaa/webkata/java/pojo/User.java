package sirsiiaa.webkata.java.pojo;

import lombok.Data;

@Data
public class User {
    /*
     * 使用lombok可以简化getter、setter的操作
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
