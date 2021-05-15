package top.cliffside.pojo;

/**
 * @author cliffside
 * @date 2021-05-14 15:40
 */
public class Emp {
    private Dept dept;
    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
    public Dept getDept() {
        return dept;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    public Emp() {
    }
    public Emp(Dept dept) {
        this.dept = dept;
    }
}
