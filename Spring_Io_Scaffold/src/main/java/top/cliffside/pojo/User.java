package top.cliffside.pojo;

/**
 * @author cliffside
 * @date 2021-05-14 14:44
 * bean 的生命周期
 * 1 通过构造器创建bean实例           执行构造器
 * 2 为bean属性赋值                         执行set方法
 * 3 初始化bean                                调用bean的初始化方法,需要配置指定调用的方法
 * 4 bean的获取                                容器对象 getBean方法
 * 5 容器关闭销毁bean                      调用销毁方法,需要配置指定调用的方法
 */
public class User {
    private Integer userid;
    private String username;
    private String password;
    public void initUser(){
        System.out.println("第三步:User初始化");
    }

    public void destoryUser(){
        System.out.println("第五步:User销毁");
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public User() {
        System.out.println("第一步:User构造");
        System.out.println("noArgConstructor");
    }
    public User(Integer userid, String username, String password) {
        System.out.println("第一步:User构造");
        System.out.println("allArgConstructor");
        this.userid = userid;
        this.username = username;
        this.password = password;
    }
    public void setUserid(Integer userid) {
        System.out.println("setUserid");
        this.userid = userid;
    }
    public void setUsername(String username) {
        System.out.println("第二步:User属性赋值");
        System.out.println("setUsername");
        this.username = username;
    }
    public void setPassword(String password) {
        System.out.println("setpassword");
        this.password = password;
    }
}