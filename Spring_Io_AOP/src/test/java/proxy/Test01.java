package proxy;

import org.junit.Test;

/**
 * @author cliffside
 * @date 2021-05-14 21:30
 */
public class Test01 {
    @Test
    public void testProxy(){
        Person person = new Person("zhangsan");
        Court court = new Layer(person);
        court.doCourt();
    }
}
interface Court{
    void doCourt();
}
class Layer implements Court{

    private Person person;

    public Layer(Person person) {
        this.person = person;
    }

    @Override
    public void doCourt() {
        System.out.println("我想给person左代理");
        person.doCourt();
    }
}
class Person implements Court{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void doCourt() {
     System.out.println(name + "i want to be proxy");
    }
}