package com.example.Jwt.Authentication.controller;

import com.example.Jwt.Authentication.model.EndUser;
import com.example.Jwt.Authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/getToken")
    public ResponseEntity<Object> getToken(@RequestBody EndUser endUser){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(endUser.getUserName(),endUser.getPassword());
        try {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid User");
        }

        final UserDetails userDetails=userDetailsService.loadUserByUsername(endUser.getUserName());


        return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(userDetails));

    }

    @GetMapping("/endUserData")
    public String data() {
        System.out.println("Verified");
        return "THis is a secret data  = sd3zc5gb1wef12v";
    }
}
