package com.example.auth1.dto;

import com.example.auth1.domain.entity.MemberEntity;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    private Long id;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일이 올바르지 않습니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
    message = "비밀번호는 대, 소문자와 숫자, 특수기호가 1개 이상 포함된 8-20자리 비밀번호여야 합니다.")
    private String password;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
