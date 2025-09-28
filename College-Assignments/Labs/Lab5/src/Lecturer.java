public class Lecturer extends Person{private int studentNumber;
    private int officeNumber;
    private String Department;

    // create a new student object with the given variables. use some variables from the person object as super method
    public Lecturer(String firstName, String lastName, String address, int DOB, String phoneNumber, char gender, int officeNumber, String department){
        super( firstName, lastName, address, DOB, phoneNumber, gender);
        this.Department = department;
        this.officeNumber = officeNumber;
    }

    //get and set the variables so that other classes can view, change and edit the variables

    public int getOfficeNumber() {
        return officeNumber;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    //print out all the details using the person print method and adding the other variables associated with lecturer

    @Override
    public void printMethod() {
        super.printMethod();
        System.out.println(this.Department);
        System.out.println(this.officeNumber);
    }
}
