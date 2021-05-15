package top.cliffside.pojo;

import java.util.Date;

/**
 * @author cliffside
 * @date 2021-05-14 14:53
 */
public class Mouse {
    private String name;
    private Date birthdate;
    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
    public Mouse() {
    }
    public Mouse(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
