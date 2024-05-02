package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import surnoi.FusionIQ.FusionIQ.data.Candidates;
import surnoi.FusionIQ.FusionIQ.data.User;
import surnoi.FusionIQ.FusionIQ.repo.CandidateRepo;
import surnoi.FusionIQ.FusionIQ.repo.UserRepo;

import java.util.Optional;
@Service
public class LoginService {
    private final UserRepo userRepo;
    private final CandidateRepo candidateRepo;

    @Autowired
    public LoginService(UserRepo userRepo, CandidateRepo candidateRepo) {
        this.userRepo = userRepo;
        this.candidateRepo = candidateRepo;
    }

    // Modify the login method to check both tables
    public Object login(String username, String password) {
        // First, check in the User table
        User user = userRepo.findByMailAndPassword(username, password);
        if (user != null) {
            return user;
        }

        // If not found in the User table, check in the Candidates table
        Optional<Candidates> candidate = candidateRepo.findByUserNameAndPassword(username, password);
        if (candidate.isPresent()) {
            return candidate;
        }

        // If not found in either table, return null
        return null;
    }

    // Other methods...
}

