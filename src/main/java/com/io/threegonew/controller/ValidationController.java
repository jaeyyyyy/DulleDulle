package com.io.threegonew.controller;

import com.io.threegonew.repository.UserRepository;
import com.io.threegonew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public ValidationController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/checkDuplicateId")
    public ResponseEntity<String> checkDuplicateId(@RequestParam(name = "userId") String userId) {
        System.out.println("userId에 대한 요청이 수신되었습니다: " + userId); // 콘솔 출력 추가
        boolean isDuplicate = userService.isIdDuplicate(userId);

        if (isDuplicate) {
            System.out.println("중복된 아이디가 감지되었습니다: " + userId); // 콘솔 출력 추가
            return ResponseEntity.badRequest().body("true");
        }
        else {
            System.out.println("사용 가능한 아이디입니다: " + userId); // 콘솔 출력 추가
            return ResponseEntity.ok("false");
        }
    }

// TODO : 이메일 중복 검사
    //
//    @GetMapping("/checkDuplicateEmail")
//    public ResponseEntity<String> checkDuplicateEmail(@RequestParam String email) {
//        System.out.println("email에 대한 요청이 수신되었습니다: " + email); // 콘솔 출력 추가
//        boolean isDuplicate = userService.isEmailDuplicate(email);
//
//        if (isDuplicate) {
//            System.out.println("중복된 이메일이 감지되었습니다: " + email); // 콘솔 출력 추가
//            return ResponseEntity.badRequest().body("true");
//        } else {
//            System.out.println("사용 가능한 이메일입니다: " + email); // 콘솔 출력 추가
//            return ResponseEntity.ok("false");
//        }
//    }

}
