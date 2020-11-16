package case_study_module_2.models;

public class Customer implements Comparable<Customer>{
    private String idCus;
    private String nameCustomer;
    private String birthday;
    private String gender;
    private String cmnd;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Services useService;

    public Customer() {
    }

    public Customer(String idCus, String nameCustomer, String birthday, String gender, String cmnd, String phoneNumber,
                    String email, String customerType, String address) {
        this.idCus = idCus;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String idCus, String nameCustomer, String birthday, String gender, String cmnd,
                    String phoneNumber, String email, String customerType, String address, Services useService) {
        this.idCus = idCus;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.useService = useService;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getUseService() {
        return useService;
    }

    public void setUseService(Services useService) {
        this.useService = useService;
    }

    public void showInfo(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id customer= " + idCus +
                "nameCustomer='" + nameCustomer + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer customer) {
        return this.getNameCustomer().compareTo(customer.getNameCustomer());
    }
}