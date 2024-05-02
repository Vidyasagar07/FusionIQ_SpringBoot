package surnoi.FusionIQ.FusionIQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import surnoi.FusionIQ.FusionIQ.data.JwtResponse;
import surnoi.FusionIQ.FusionIQ.data.LoginRequest;
import surnoi.FusionIQ.FusionIQ.service.LoginService;
import surnoi.FusionIQ.FusionIQ.service.TokenService;
import surnoi.FusionIQ.FusionIQ.service.UserService;
@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;
    private final TokenService tokenService;
    @Autowired
    public LoginController(LoginService loginService, TokenService tokenService) {
        this.loginService = loginService;
        this.tokenService = tokenService;
    }

    // Endpoint for user login
//    @PostMapping("/log")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        Object authenticatedUser = loginService.login(loginRequest.getMail(), loginRequest.getPassword());
//        if (authenticatedUser != null) {
//            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Object authenticatedUser = loginService.login(loginRequest.getMail(), loginRequest.getPassword());
        if (authenticatedUser != null) {
            // Generate JWT token
            String jwtToken = tokenService.generateToken(loginRequest.getMail());
            return new ResponseEntity<>(new JwtResponse(jwtToken), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

}

