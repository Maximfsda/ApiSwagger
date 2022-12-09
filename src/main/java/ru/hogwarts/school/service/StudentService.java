package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exeptions.StudentNotFoundExeption;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private Map<Long, Student> students = new HashMap<>();
    private Long counter = 1L;

    public Student createStudent(Student student) {
        students.put(counter, student);
        counter++;
        return student;
    }

    public Student updateFaculty(Long studentId,Student student) {
        if(this.students.containsKey(studentId)){
            Student oldStudent = this.students.get(studentId);
            oldStudent.setName(student.getName());
            oldStudent.setAge(student.getAge());
            return oldStudent;
        }
        else {
            throw new StudentNotFoundExeption();
        }
    }
    public Student getStudentById(Long studentId) {
        if(this.students.containsKey(studentId)){
            return this.students.get((studentId));
        }
        else {
            throw new StudentNotFoundExeption();
        }
    }

    public Student deleteStudent(Long studentId) {
        if(this.students.containsKey(studentId)){
            return students.remove(studentId);
        }
        else {
            throw new StudentNotFoundExeption();
        }
    }
}
