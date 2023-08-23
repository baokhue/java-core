package mobilephone_management.models;

public class AbroadMobilePhone extends MobilePhone{
    private String country;
    private String status;

    public AbroadMobilePhone() {
    }

    public AbroadMobilePhone(int id, String name, long cost, int number, String producer, String country, String status) {
        super(id, name, cost, number, producer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return getFile() + "," + country + "," + status;
    }

    @Override
    public String toString() {
        return "AbroadMobilePhone{" +
                super.toString() +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
