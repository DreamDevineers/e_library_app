package ng.eLibrarySystem.controllers;

import ng.eLibrarySystem.dtos.requests.CreateMemberRequest;
import ng.eLibrarySystem.dtos.responses.CreateMemberResponse;
import ng.eLibrarySystem.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/members")
    public CreateMemberResponse createMember(@RequestBody CreateMemberRequest request) {
        return memberService.createMember(request);
    }
}