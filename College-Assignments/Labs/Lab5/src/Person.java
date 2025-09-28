public class Person {
    //create instance variables

    private String firstName;
    private String lastName;
    private String address;
    private int DOB;
    private String phoneNumber;
    private char gender;

    //create a person object with given information
    public Person(String firstName, String lastName, String address, int DOB, String phoneNumber, char gender){
        this.address = address;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
    }

    //get and return each variable so that other classes can read the variables
    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getDOB() {
        return DOB;
    }

    public String getFirstName() { return firstName; }

    public void setAddress(String address) {
        this.address = address;
    }

    //Set the variables so that other classes can change and edit the variables

    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //print out all the details

    public void printMethod(){
        System.out.println(this.firstName);
        System.out.println(this.lastName);
        System.out.println(this.address);
        System.out.println(this.DOB);
        System.out.println(this.gender);
        System.out.println(this.phoneNumber);
    }
}
