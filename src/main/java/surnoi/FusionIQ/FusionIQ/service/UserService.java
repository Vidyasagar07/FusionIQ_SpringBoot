package surnoi.FusionIQ.FusionIQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import surnoi.FusionIQ.FusionIQ.data.User;
import surnoi.FusionIQ.FusionIQ.repo.UserRepo;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final JavaMailSender javaMailSender;

    @Autowired
    public UserService(UserRepo userRepo, JavaMailSender javaMailSender) {
        this.userRepo = userRepo;
        this.javaMailSender = javaMailSender;
    }
    public User save(User user) {
        return userRepo.save(user);
    }
    public User getHrById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public User saveHr(User user) {
        return userRepo.save(user);
    }
    public void deleteHr(Long id) {
        userRepo.deleteHrById(id);
    }
    public List<User> getAllHrs() {
        return userRepo.findAll();
    }
    public boolean validateLogin(String email, String password) {
        User user = userRepo.findByMailAndPassword(email, password);
        return user != null;
    }
//public boolean validateLogin(String email, String password, boolean isAdmin) {
//    if (isAdmin) {
//        return userRepo.findByMailAndPasswordAndIsAdmin(email, password, true) != null;
//    } else {
//        return userRepo.findByMailAndPassword(email, password) != null;
//    }
//}

    public User registerUser(User registrationData) {
        User savedUser = userRepo.save(registrationData);
        return savedUser;
    }
    public User getByMail(String mail)  {
        return userRepo.findByMail(mail);
    }
    public boolean existsByMail(String email) {
        return userRepo.existsByMail(email);
    }

    public String generateAndSaveOTP(String email) {
        // Generate random OTP
        String otp = generateRandomOTP();
        // Save the OTP to the user entity
        User user = getByMail(email);
        if (user != null) {
            user.setOtp(otp);
            userRepo.save(user);
            return otp;
        }
        return null;
    }

    private static final int OTP_LENGTH = 6;

    private String generateRandomOTP() {
        String numbers = "0123456789";
        StringBuilder otpBuilder = new StringBuilder(OTP_LENGTH);
        Random random = new Random();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otpBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return otpBuilder.toString();
    }
    public void sendOTPByEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your One-Time Password (OTP)");
        message.setText("Your OTP code to FusionIQ login is: " + otp);
        javaMailSender.send(message);
    }
    public boolean verifyOTP(String email, String otp) {
        User user = getByMail(email);
        if (user != null && user.getOtp() != null && user.getOtp().equals(otp)) {
            user.setOtp(null);
            userRepo.save(user);
            return true;
        }
        return false;
    }

}
