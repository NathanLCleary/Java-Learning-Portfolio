public class Student extends Person{
    private int studentNumber;
    private int yearOfStudy;

    // create a new student object with the given variables. use some variables from the person object as super method
    public Student(String firstName, String lastName, String address, int DOB, String phoneNumber, char gender, int studentNumber, int yearOfStudy){
        super( firstName, lastName, address, DOB, phoneNumber, gender);
        this.studentNumber = studentNumber;
        this.yearOfStudy = yearOfStudy;
    }

    //get and set the variables so that other classes can view, change and edit the variables
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    //print out all the details using the person print method and adding the other variables associated with student
    @Override
    public void printMethod() {
        super.printMethod();
        System.out.println(this.studentNumber);
        System.out.println(this.yearOfStudy);
    }
}
