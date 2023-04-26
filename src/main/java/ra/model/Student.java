package ra.model;

public class Student {
    private String id;
    private String name;
    private String birthday;
    private boolean gen = true;
    private String address;
    private String phone;
    private String place;

    public Student() {
    }

    public Student(String id, String name, String birthday, boolean gen, String address, String phone, String place) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gen = gen;
        this.address = address;
        this.phone = phone;
        this.place = place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGen() {
        return gen;
    }

    public void setGen(boolean gen) {
        this.gen = gen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
