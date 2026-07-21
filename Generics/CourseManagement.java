import java.util.*;

abstract class CourseType {

    String type;

    CourseType(String type) {
        this.type = type;
    }

    void display() {
        System.out.println(type);
    }
}

class ExamCourse extends CourseType {

    ExamCourse() {
        super("Exam Course");
    }
}

class AssignmentCourse extends CourseType {

    AssignmentCourse() {
        super("Assignment Course");
    }
}

class ResearchCourse extends CourseType {

    ResearchCourse() {
        super("Research Course");
    }
}

// Generic Class
class Course<T extends CourseType> {

    List<T> courses = new ArrayList<>();

    void addCourse(T course) {
        courses.add(course);
    }

    List<T> getCourses() {
        return courses;
    }
}

public class CourseManagement {

    static void display(List<? extends CourseType> list) {

        for (CourseType c : list) {
            c.display();
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> exam = new Course<>();

        exam.addCourse(new ExamCourse());
        exam.addCourse(new ExamCourse());

        display(exam.getCourses());
    }
}