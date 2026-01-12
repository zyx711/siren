package edu.hnzj.pojo;

public class User {
    //私有成员变量
    private int id;
    private String name;
    private String password;

    //部分参数构造方法（重载构造，满足不同赋值场景）
    public User (String id, String name) {
        this.id = Integer.parseInt(id);
        this.name = name;
    }

    // 全参构造
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    //构造无参方法，pojo必备，方便框架反射创建对象
    public User() {
    }

    //getter方法：获取私有属性的值
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    //setter方法：修改私有属性的值
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    //toString方法：方便打印对象的属性信息（调试/日志常用）
    //加@Override注解，告诉编译器这是重写父类的方法
    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",password='" + password + '\'' +
                '}';
    }

    // 测试代码（可选，用于验证效果）
    public static void main(String[] args) {
        // 创建一个User对象
        User user = new User(1, "张三", "123456");
        // 打印对象（底层会自动调用toString方法）
        System.out.println(user);
    }
}
