package functional.programming.interpreter;

public class Pfbu134Response extends HostResponse {
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pfbu134Response{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
