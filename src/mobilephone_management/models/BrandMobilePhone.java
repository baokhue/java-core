package mobilephone_management.models;

public class BrandMobilePhone extends MobilePhone{
    private String date;
    private String scope;

    public BrandMobilePhone() {
    }

    public BrandMobilePhone(int id, String name, long cost, int number, String producer, String date, String scope) {
        super(id, name, cost, number, producer);
        this.date = date;
        this.scope = scope;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String getInfo() {
        return getFile() + "," + date + "," + scope;
    }

    @Override
    public String toString() {
        return "BrandMobilePhone{" +
                super.toString() +
                "date='" + date + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
