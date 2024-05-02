package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Course;
import surnoi.FusionIQ.FusionIQ.repo.CourseRepo;
import java.util.List;
import java.util.Optional;
@RestController
public class CourseController {
    @Autowired
    CourseRepo courseRepo;
    @PostMapping("api/courses")
    public ResponseEntity<Course> saveRequest(@RequestBody Course course){
        return new ResponseEntity<>(courseRepo.save(course), HttpStatus.CREATED);
    }

    @GetMapping("/api/coursesall")
    public ResponseEntity<List<Course>> getEmployeesSortedByIdDescending(){
        Sort sort= Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(courseRepo.findAll(sort), HttpStatus.OK);
    }
    @GetMapping("/api/courses/{id}")
    public ResponseEntity<Course> getEmployee(@PathVariable long id ) {
        Optional<Course> fusionEntity= courseRepo.findById(id);
        if (fusionEntity.isPresent()) {
            return new ResponseEntity<>(fusionEntity.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

