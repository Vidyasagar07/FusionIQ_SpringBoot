package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Devops;
import surnoi.FusionIQ.FusionIQ.repo.DevRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class DevController {
    @Autowired
    DevRepo devRepo;

    @PostMapping("/api/postdevops")
    public ResponseEntity<Devops> saveRequest(@RequestBody Devops devops) {
        return new ResponseEntity<>(devRepo.save(devops), HttpStatus.CREATED);

    }

    @GetMapping("/api/devopsall")
    public ResponseEntity<List<Devops>> getEmployeesSortedByIdDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(devRepo.findAll(sort), HttpStatus.OK);

    }
    @GetMapping("/api/getdevops/{id}")
    public ResponseEntity<Devops> getEmployee(@PathVariable long id ) {
        Optional<Devops> Devops = devRepo.findById(id);
        if (Devops.isPresent()) {
            return new ResponseEntity<>(Devops.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/api/devops/delete/{id}")
    public ResponseEntity<Void> deleteDevops(@PathVariable long id ) {
        Optional<Devops>Devops= devRepo.findById(id);
        if (Devops.isPresent()) {
            devRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/updatedevops/{id}")
    public ResponseEntity<Devops> updateDevops(@PathVariable long id, @RequestBody Devops devops) {
        Optional<Devops> datamodel = devRepo.findById(id);
        if (datamodel.isPresent()) {

            datamodel.get().setCourse(devops.getCourse());
            datamodel.get().setBatchNo(devops.getBatchNo());
            datamodel.get().setEmail(devops.getEmail());
            datamodel.get().setFirstName(devops.getFirstName());
            datamodel.get().setLastName(devops.getLastName());
            datamodel.get().setGender(devops.getGender());
            datamodel.get().setUserName(devops.getUserName());
            datamodel.get().setPassword(devops.getPassword());
            datamodel.get().setPhoneNumber(devops.getPhoneNumber());
            datamodel.get().setDateOfJoining(devops.getDateOfJoining());
            datamodel.get().setBasics(devops.getBasics());
            datamodel.get().setDevtoolsStatus(devops.getDevtoolsStatus());
            datamodel.get().setDevopsarchitectureStatus(devops.getDevopsarchitectureStatus());
            datamodel.get().setDevopsautomationStatus(devops.getDevopsautomationStatus());
            datamodel.get().setDevopspipeStatus(devops.getDevopspipeStatus());
            datamodel.get().setTerraformStatus(devops.getTerraformStatus());
            return new ResponseEntity<>(devRepo.save(datamodel.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
