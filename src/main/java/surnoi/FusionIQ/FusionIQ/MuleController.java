package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Mulesoft;
import surnoi.FusionIQ.FusionIQ.repo.MuleRepo;

import java.util.List;
import java.util.Optional;
@RestController
public class MuleController {
    @Autowired
    MuleRepo muleRepo;

    @PostMapping("/api/postmulesoft")
    public ResponseEntity<Mulesoft> saveRequest(@RequestBody Mulesoft mulesoft) {
        return new ResponseEntity<>(muleRepo.save(mulesoft), HttpStatus.CREATED);


    }

    @GetMapping("/api/getfusionall")
    public ResponseEntity<List<Mulesoft>> getEmployeesSortedByIdDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(muleRepo.findAll(sort), HttpStatus.OK);

    }

    @GetMapping("/api/getfusion/{id}")
    public ResponseEntity<Mulesoft> getEmployee(@PathVariable long id) {
        Optional<Mulesoft> fusionEntity = muleRepo.findById(id);
        if (fusionEntity.isPresent()) {
            return new ResponseEntity<>(fusionEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/api/mule/delete/fusion/{id}")
    public ResponseEntity<Void> deleteMulesoft(@PathVariable long id) {
        Optional<Mulesoft> mulesoft = muleRepo.findById(id);
        if (mulesoft.isPresent()) {
            muleRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






    @PutMapping("/api/updatemulesoft/{id}")
    public ResponseEntity<Mulesoft> updateMulesoft(@PathVariable int id, @RequestBody Mulesoft mulesoft) {
        Optional<Mulesoft> datamodel = muleRepo.findById(id);
        if (datamodel.isPresent()) {
            datamodel.get().setCourse(mulesoft.getCourse());
            datamodel.get().setBatchNo(mulesoft.getBatchNo());
            datamodel.get().setEmail(mulesoft.getEmail());
            datamodel.get().setFirstName(mulesoft.getFirstName());
            datamodel.get().setLastName(mulesoft.getLastName());
            datamodel.get().setGender(mulesoft.getGender());
            datamodel.get().setUserName(mulesoft.getUserName());
            datamodel.get().setPassword(mulesoft.getPassword());
            datamodel.get().setPhoneNumber(mulesoft.getPhoneNumber());
            datamodel.get().setDateOfJoining(mulesoft.getDateOfJoining());
            datamodel.get().setBasics(mulesoft.getBasics());
            datamodel.get().setRamlStatus(mulesoft.getRamlStatus());
            datamodel.get().setActiveMQintegrationStatus(mulesoft.getActiveMQintegrationStatus());
            datamodel.get().setRestapiStatus(mulesoft.getRestapiStatus());
            datamodel.get().setApileadconnectivityStatus(mulesoft.getApileadconnectivityStatus());
            datamodel.get().setBatchprocessingStatus(mulesoft.getBatchprocessingStatus());
            datamodel.get().setErrorhandlingStatus(mulesoft.getErrorhandlingStatus());
            return new ResponseEntity<>(muleRepo.save(datamodel.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
