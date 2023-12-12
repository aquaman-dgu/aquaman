//package com.dongguk.cse.aquaman.dto.request;
//
//import com.dongguk.cse.aquaman.domain.Member;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class SignUpDTO {
//
//    private String username;
//    private String password;
//    private String nickname;
//    private String address;
//    private String phone;
//    private List<String> roles = new ArrayList<>();
//
//    public Member toEntity(String encodedPassword, List<String> roles){
//        return Member.builder()
//                .username(username)
//                .password(encodedPassword)
//                .nickname(nickname)
//                .address(address)
//                .phone(phone)
//                .roles(roles)
//                .build();
//    }
//}
