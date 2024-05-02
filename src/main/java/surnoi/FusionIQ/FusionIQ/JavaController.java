package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Java;
import surnoi.FusionIQ.FusionIQ.repo.JavaRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class JavaController {
    @Autowired
    JavaRepo javaRepo;
//    @Autowired
//    private CourseService courseService;
//
//    @PostMapping("/register")
//    public ResponseEntity<Java> registerStudent(@RequestBody Java java) {
//        Java savedJavaStudent = courseService.registerJava(java);
//        return ResponseEntity.ok(savedJavaStudent);
//    }

    @PostMapping("/api/saveJavaEmployee")
    public ResponseEntity<Java> saveJavaRequest(@RequestBody Java java) {
        return new ResponseEntity<>(javaRepo.save(java), HttpStatus.CREATED);
    }

    @GetMapping("/api/getJavaEmployees")
    public ResponseEntity<List<Java>> getJavaEntity() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(javaRepo.findAll(sort), HttpStatus.OK);
    }

    @GetMapping("/api/getJavaEmployee/{id}")
    public ResponseEntity<Java> getJavaEntityById(@PathVariable long id) {
        Optional<Java> employee = javaRepo.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/deleteJavaEntity/fusion/{id}")
    public ResponseEntity<Void> deleteJavaEntity(@PathVariable long id) {
        Optional<Java> fusionEntity = javaRepo.findById(id);
        if (fusionEntity.isPresent()) {
            javaRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/updateJavaEntity/{id}")
    public ResponseEntity<Java> updateJavaEntity(@PathVariable int id, @RequestBody Java java) {
        Optional<Java> datamodel = javaRepo.findById(id);
        if (datamodel.isPresent()) {
            datamodel.get().setCourse(java.getCourse());
            datamodel.get().setBatchNo(java.getBatchNo());
            datamodel.get().setEmail(java.getEmail());
            datamodel.get().setFirstName(java.getFirstName());
            datamodel.get().setLastName(java.getLastName());
            datamodel.get().setGender(java.getGender());
            datamodel.get().setUserName(java.getUserName());
            datamodel.get().setPassword(java.getPassword());
            datamodel.get().setPhoneNumber(java.getPhoneNumber());
            datamodel.get().setDateOfJoining(java.getDateOfJoining());
            datamodel.get().setJavaBasicsStatus(java.getJavaBasicsStatus());
            datamodel.get().setOopsStatus(java.getOopsStatus());
            datamodel.get().setExceptionHandlingStatus(java.getExceptionHandlingStatus());
            datamodel.get().setCollectionsStatus(java.getCollectionsStatus());
            datamodel.get().setMultithreadingStatus(java.getMultithreadingStatus());
            datamodel.get().setIoStatus(java.getIoStatus());
            return new ResponseEntity<>(javaRepo.save(datamodel.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
