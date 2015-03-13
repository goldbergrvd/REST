package haha.bean;

public class Three {
    private String name;
    private Two two;
    private One one;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Two getTwo() {
        return two;
    }

    public void setTwo(Two two) {
        this.two = two;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }

    @Override
    public String toString() {
        return "Three{" +
                "name='" + name + '\'' +
                ", two=" + two.toString() +
                ", one=" + one.toString() +
                '}';
    }
}
