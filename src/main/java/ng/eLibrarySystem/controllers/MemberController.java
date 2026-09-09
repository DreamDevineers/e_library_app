package ng.eLibrarySystem.controllers;

import ng.eLibrarySystem.data.models.Member;
import ng.eLibrarySystem.dtos.requests.CreateMemberRequest;
import ng.eLibrarySystem.dtos.responses.CreateMemberResponse;
import ng.eLibrarySystem.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/members")
    public CreateMemberResponse createMember(@RequestBody CreateMemberRequest request) {
        return memberService.createMember(request);
    }

    @GetMapping("/member/{id}")
    public Member getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    @GetMapping("/member/email/{email}")
    public Member getMemberByEmail(@PathVariable String email) {
        return memberService.getMemberByEmail(email);
    }
}