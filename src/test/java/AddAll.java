import com.Application;
import com.entity.Classroom;
import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.repository.ClassroomRepository;
import com.repository.CourseRepository;
import com.repository.StudentCourseRepository;
import com.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Application.class)
public class AddAll {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Test
    @Rollback(false)
    @Transactional
    void AddAllTest(){


        List<Student> students = new ArrayList<>();

        students.addAll(List.of(new Student("a", "a@gmail.com"),
                new Student("b", "b@gmail.com"),
                new Student("c", "c@gmail.com"),
                new Student("d", "d@gmail.com"),
                new Student("e", "e@gmail.com"),
                new Student("f", "f@gmail.com"),
                new Student("g", "g@gmail.com"),
                new Student("h", "h@gmail.com"),
                new Student("i", "i@gmail.com"),
                new Student("j", "j@gmail.com")));

        Classroom classroom1 = new Classroom();
        classroom1.setNumber(1);

        Classroom classroom2 = new Classroom();
        classroom2.setNumber(2);

        Course c1= new Course();
        c1.setName("SOA");
        c1.setNumberId(566);
        c1.setClassroom(classroom1);

        Course c2= new Course();
        c2.setName("HCI");
        c2.setNumberId(532);
       c2.setClassroom(classroom1);

        Course c3= new Course();
        c3.setName("Data Analysis");
        c3.setNumberId(541);
        c3.setClassroom(classroom2);

        classroom1.setCourses(List.of(c1, c2));
        classroom2.setCourses(List.of(c3));

      // List<Classroom> classrooms = classroomRepository.saveAll(List.of(classroom1, classroom2));

        List<Classroom> classrooms = List.of(classroom1, classroom2);

        List<Course> courses = new ArrayList<>();
        courses.addAll(classroom1.getCourses());
        courses.addAll(classroom2.getCourses());

        List<StudentCourse> studentCourses = List.of(
                new StudentCourse(courses.get(0), students.get(0)), //0
                new StudentCourse(courses.get(1), students.get(0)), //1
                new StudentCourse(courses.get(2), students.get(0)), //2
                new StudentCourse(courses.get(0), students.get(1)), //3
                new StudentCourse(courses.get(1), students.get(1)), //4
                new StudentCourse(courses.get(2), students.get(2)) //5
                );

       //studentCourses= studentCourseRepository.saveAll(studentCourses);

        students.get(0).setStudentCourseList(List.of(studentCourses.get(0), studentCourses.get(1),  studentCourses.get(2)));
        students.get(1).setStudentCourseList(List.of(studentCourses.get(3), studentCourses.get(4)));
        students.get(2).setStudentCourseList(List.of(studentCourses.get(5)));

        courses.get(0).setStudentCourseList(List.of(studentCourses.get(0), studentCourses.get(3)));
        courses.get(1).setStudentCourseList(List.of(studentCourses.get(1), studentCourses.get(4)));
        courses.get(2).setStudentCourseList(List.of(studentCourses.get(2), studentCourses.get(5)));

        studentRepository.saveAll(students);

        classrooms = classroomRepository.saveAll(List.of(classroom1, classroom2));


    }
}
