package top.cliffside.pojo;

/**
 * @author cliffside
 * @date 2021-05-14 14:54
 */
public class Cat {
    private String name;
    private Mouse mouse;
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", mouse1=" + mouse +
                '}';
    }
    public Cat() {
    }
    public Cat(String name, Mouse mouse) {
        this.name = name;
        this.mouse = mouse;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Mouse getMouse() {
        return mouse;
    }
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
