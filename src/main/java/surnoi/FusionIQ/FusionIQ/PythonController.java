package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import surnoi.FusionIQ.FusionIQ.data.Python;
import surnoi.FusionIQ.FusionIQ.repo.PythonRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class PythonController {
    @Autowired
    PythonRepo pythonRepo;
    @PostMapping("/api/savePythonEmployee")
    public ResponseEntity<Python> savePythonRequest(@RequestBody Python python){
        return new ResponseEntity<>(pythonRepo.save(python), HttpStatus.CREATED);
    }
    @GetMapping("/api/getPythonEmployees")
    public ResponseEntity<List<Python>> getPythonEntity(){
        Sort sort= Sort.by(Sort.Direction.DESC, "id");
        return new ResponseEntity<>(pythonRepo.findAll(sort), HttpStatus.OK);
    }
    @GetMapping("/api/getPythonEmployee/{id}")
    public ResponseEntity<Python> getPythonEntityById(@PathVariable long id ) {
        Optional<Python> employee= pythonRepo.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/api/deletePython/fusion/{id}")
    public ResponseEntity<Void> deletePythonEntity(@PathVariable long id ) {
        Optional<Python> fusionEntity= pythonRepo.findById(id);
        if (fusionEntity.isPresent()) {
            pythonRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/api/updatePythonEntity/{id}")
    public ResponseEntity<Python> updatePythonEntity(@PathVariable long id, @RequestBody Python python) {
        Optional<Python> pythonData = pythonRepo.findById(id);
        if (pythonData.isPresent()) {
            pythonData.get().setCourse(python.getCourse());
            pythonData.get().setBatchNo(python.getBatchNo());
            pythonData.get().setEmail(python.getEmail());
            pythonData.get().setFirstName(python.getFirstName());
            pythonData.get().setLastName(python.getLastName());
            pythonData.get().setGender(python.getGender());
            pythonData.get().setUserName(python.getUserName());
            pythonData.get().setPassword(python.getPassword());
            pythonData.get().setPhoneNumber(python.getPhoneNumber());
            pythonData.get().setDateOfJoining(python.getDateOfJoining());
            pythonData.get().setPythonBasicsStatus(python.getPythonBasicsStatus());
            pythonData.get().setListsStatus(python.getListsStatus());
            pythonData.get().setTuplesStatus(python.getTuplesStatus());
            pythonData.get().setSetsStatus(python.getSetsStatus());
            pythonData.get().setDictionariesStatus(python.getDictionariesStatus());
            pythonData.get().setFunctionsStatus(python.getFunctionsStatus());
            return new ResponseEntity<>(pythonRepo.save(pythonData.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
