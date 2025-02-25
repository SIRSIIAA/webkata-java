package sirsiiaa.webkata.java;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
     * spring-tx 包含了封装好的事务AOP以及TransactionManager接口
     * spring-jdbc 包含了DataSourceTransactionManager实现类，封装面向Connection的事务操作
     * spring-orm 包含了HibernateTransactionManager、JPATransactionManager实现类，封装面向Hibernate、JPA的事务操作
     *
     * 使用tx的步骤：
     *  1. 引入所需的事务管理器
     *  2. 将事务管理器纳入IoC容器，然后配置生效
     */
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}