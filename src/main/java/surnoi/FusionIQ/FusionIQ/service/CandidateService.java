package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import surnoi.FusionIQ.FusionIQ.data.Candidates;
import surnoi.FusionIQ.FusionIQ.exception.UserNotFoundException;
import surnoi.FusionIQ.FusionIQ.repo.CandidateRepo;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepo candidateRepo;
    @Autowired
    public CandidateService(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }
    public Candidates addCandidate(Candidates candidates){
        return candidateRepo.save(candidates);
    }
    public Candidates updateCandidate(Candidates candidates){
        return candidateRepo.save(candidates);
    }
    public List<Candidates> findAllCandidates(){
        return candidateRepo.findAll();
    }
    public Candidates findCandidateById(long id){
        return candidateRepo.findById(id).orElseThrow(() ->new UserNotFoundException("User by id " + id + " was not found"));
    }
    public Candidates authenticateCandidate(String userName, String password) {
        return candidateRepo.findByUserNameAndPassword(userName, password)
                .orElseThrow(() -> new UserNotFoundException("Invalid username or password"));
    }
    public void deleteCandidate(long id){
        candidateRepo.deleteById(id);
    }
}
