package com.org.leetstats.controllers.auth;

import com.org.leetstats.entities.auth.User;
import com.org.leetstats.enums.InjestExceptionEnum;
import com.org.leetstats.exceptions.InjestException;
import com.org.leetstats.repos.auth.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leetstats/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserRepo userRepo;

    @ResponseBody
    @GetMapping("/me")
    public String getUserName(Authentication authentication){

        UserDetails user = (UserDetails) authentication.getPrincipal();
        User userDTO = userRepo.findByEmail(user.getUsername()).orElseThrow(() -> new InjestException(InjestExceptionEnum.NOT_AUTHENTICATED,"authentication Error"));

        return userDTO.getName();
    }

}
