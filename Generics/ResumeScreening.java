import java.util.*;

abstract class JobRole {

    String role;

    JobRole(String role) {
        this.role = role;
    }

    void display() {
        System.out.println(role);
    }
}

class SoftwareEngineer extends JobRole {

    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {

    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {

    ProductManager() {
        super("Product Manager");
    }
}

// Generic Class
class Resume<T extends JobRole> {

    T role;

    Resume(T role) {
        this.role = role;
    }

    void processResume() {
        System.out.print("Processing Resume for ");
        role.display();
    }
}

public class ResumeScreening {

    // Wildcard Method
    static void screening(List<? extends JobRole> roles) {

        for (JobRole role : roles) {
            role.display();
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> resume =
                new Resume<>(new SoftwareEngineer());

        resume.processResume();

        List<JobRole> list = new ArrayList<>();

        list.add(new SoftwareEngineer());
        list.add(new DataScientist());
        list.add(new ProductManager());

        screening(list);
    }
}