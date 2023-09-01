package com.btb.chalKak.domain.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidateInfoRequest {

    private Boolean isDuplicated;
}
