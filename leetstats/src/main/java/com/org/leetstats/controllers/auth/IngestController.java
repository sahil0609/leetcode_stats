package com.org.leetstats.controllers.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingest")
public class IngestController {

    @PostMapping("/submitted")
    public ResponseEntity<?> problemInjest(@AuthenticationPrincipal UserDetails principal){
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }


}
