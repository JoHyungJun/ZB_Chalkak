package com.btb.chalKak.domain.member.controller;

import antlr.Token;
import com.btb.chalKak.common.response.service.ResponseService;
import com.btb.chalKak.common.security.dto.TokenDto;
import com.btb.chalKak.common.security.request.TokenRequestDto;
import com.btb.chalKak.common.util.ValidationUtils;
import com.btb.chalKak.domain.member.dto.request.SignInMemberRequest;
import com.btb.chalKak.domain.member.dto.request.SignUpMemberRequest;
import com.btb.chalKak.domain.member.dto.response.SignInMemberResponse;
import com.btb.chalKak.domain.member.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.btb.chalKak.common.response.type.SuccessCode.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class SignController {

    private final MemberService memberService;
    private final ResponseService responseService;


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(
            @Valid @RequestBody SignUpMemberRequest request
            , BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            String errorMessage = ValidationUtils.getErrorMessageFromBindingResult(bindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseService.failure(errorMessage));
        }

        memberService.signUp(request);
        return ResponseEntity.ok(responseService.successWithNoContent(SUCCESS_SAVE_MEMBER));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInMemberRequest request){
        SignInMemberResponse data = memberService.SignIn(request);
        return ResponseEntity.ok(responseService.success(data, SUCCESS_SIGN_IN));
    }

    // 사라질 수도 있는 api
    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(@RequestBody TokenRequestDto tokenRequestDto){
        TokenDto data = memberService.reissue(tokenRequestDto);
        return ResponseEntity.ok(responseService.success(data, SUCCESS_REISSUE));
    }

    @PutMapping("/signout")
    public ResponseEntity<?> signOut(HttpServletRequest request) {
        memberService.signOut(request);
        return ResponseEntity.ok(responseService.successWithNoContent(SUCCESS_SIGN_OUT));
    }


}
