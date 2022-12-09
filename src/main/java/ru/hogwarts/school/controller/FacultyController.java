package ru.hogwarts.school.controller;


import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("facultyId")
    public Faculty getFaculty(@PathVariable Long facultyId) {
       return facultyService.getFacultyById(facultyId);

    }

    @PutMapping()
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty.getId(), faculty);
    }

//    @PostMapping
//    public Faculty deleteFaculty(@RequestBody Long facultyId) {
//        return facultyService.deleteFaculty(facultyId);
//    }
}

