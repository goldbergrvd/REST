package haha.bean;

public class Two {
    private String name;
    private One one;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }

    @Override
    public String toString() {
        return "Two{" +
                "name='" + name + '\'' +
                ", one=" + one.toString() +
                '}';
    }
}
