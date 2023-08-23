package mobilephone_management.models;

public abstract class MobilePhone {
    private int id;
    private String name;
    private long cost;
    private int number;
    private String producer;

    public MobilePhone() {
    }

    public MobilePhone(int id, String name, long cost, int number, String producer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.number = number;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public abstract String getInfo();

    public String getFile(){
        return id + "," + name + "," + cost + "," + number + "," + producer;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", number=" + number +
                ", producer='" + producer + '\'' +
                '}';
    }
}
