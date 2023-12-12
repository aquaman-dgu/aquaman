//package com.dongguk.cse.aquaman.dto;
//
//import com.dongguk.cse.aquaman.domain.Member;
//import lombok.*;
//
//
//@Getter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class MemberDTO {
//
//    private Long id;
//    private String username;
//    private String nickname;
//    private String address;
//    private String phone;
//
//    static public MemberDTO toDto(Member member) {
//        return MemberDTO.builder()
//                .id(member.getId())
//                .username(member.getUsername())
//                .nickname(member.getNickname())
//                .address(member.getAddress())
//                .phone(member.getPhone()).build();
//    }
//
//    public Member toEntity() {
//        return Member.builder()
//                .id(id)
//                .username(username)
//                .nickname(nickname)
//                .address(address)
//                .phone(phone).build();
//    }
//}
