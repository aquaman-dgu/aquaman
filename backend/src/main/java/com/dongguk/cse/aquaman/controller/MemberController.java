//package com.dongguk.cse.aquaman.controller;
//
//import com.dongguk.cse.aquaman.dto.MemberDTO;
//import com.dongguk.cse.aquaman.dto.request.SignInDTO;
//import com.dongguk.cse.aquaman.dto.request.SignUpDTO;
//import com.dongguk.cse.aquaman.dto.response.JwtToken;
//import com.dongguk.cse.aquaman.security.util.SecurityUtil;
//import com.dongguk.cse.aquaman.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberController {
//
//    private final MemberService memberService;
//
//    @PostMapping("/sign-up")
//    public ResponseEntity<MemberDTO> signUp(@RequestBody SignUpDTO signUpDTO){
//        MemberDTO savedMemberDto = memberService.signUp(signUpDTO);
//        return ResponseEntity.ok(savedMemberDto);
//    }
//
//    @PostMapping("/sign-in")
//    public JwtToken signIn(@RequestBody SignInDTO signInDto) {
//        String username = signInDto.getUsername();
//        String password = signInDto.getPassword();
//        JwtToken jwtToken = memberService.signIn(username, password);
//        log.info("request username = {}, password = {}", username, password);
//        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
//        return jwtToken;
//    }
//
//    @PostMapping("/test")
//    public String test() {
//        return SecurityUtil.getCurrentUsername();    }
//}
