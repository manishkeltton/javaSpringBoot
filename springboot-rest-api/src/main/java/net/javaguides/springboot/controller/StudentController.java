package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students") // base URL
public class StudentController {

//    @GetMapping("student")
//    public Student getStudent(){
//        Student student = new Student(1,  "Ramesh", "Kumar");
//        return student;
//    }

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,  "Ramesh", "Kumar");
//        return new ResponseEntity<>(student, HttpStatus.OK) ;
//        return ResponseEntity.ok(student);
        return  ResponseEntity.ok()
                .header("custom-header", "ramesh")
                .body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Amit","Sharma"));
        students.add(new Student(2,"Anish","Sharma"));
        students.add(new Student(3,"Golu","Sharma"));
        students.add(new Student(4,"Manish","Sharma"));
        return ResponseEntity.ok(students);
    }

//    Spring BOOT Rest API with Path Variable
//    {id} - URI template

    /**
     * @PathVariable
     * @param id
     * @return
     * @PathVariable annotation used on a method argument to bind it to the value of a URI template variable
     */
//    @GetMapping("students")
//    public Student studentPathVariable(@PathVariable int id){
//        return new Student(id, "Manish", "sharma");
//    }
//     @GetMapping("students/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId){
//        return new Student(studentId, "Manish", "sharma");
//    }
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

//   Spring boot REST API with Request Param
//    http://localhost:8080/students/query?id=1&firstName=Sunny&lastName=Sharma
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

//    Spring boot REST API that handles HTTP POST Request - Creating new resource
//    @PostMapping and @RequestBody

    /**
     * @PostMapping - annotation is used for mapping HTTP POST request onto specific handler method.
     * @RequestBody - Annotation is responsible for retrieving the HTTP request body and automatically converting it
     * to the Java object.
     * - Annotation internally uses Spring provided HttpMessageConverter to convert JSON into Java object.
     * @param student
     * @return
     */
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    Spring boot REST API that handles HTTP PUT Request - Updating existing resource
    /**
     * @PutMapping annotation for mapping HTTP PUT request onto specific handler method
     * @param student
     * @return
     */
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

//    Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
    /**
     * @DeleteMapping - annotation for mapping HTTP DELETE request onto specific handler method
     * @param studentID
     * @return
     */
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentID){
        System.out.println(studentID);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
