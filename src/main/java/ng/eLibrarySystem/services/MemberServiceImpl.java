package ng.eLibrarySystem.services;

import ng.eLibrarySystem.data.models.Member;
import ng.eLibrarySystem.data.repositories.MemberRepository;
import ng.eLibrarySystem.dtos.requests.CreateMemberRequest;
import ng.eLibrarySystem.dtos.responses.CreateMemberResponse;
import ng.eLibrarySystem.enums.MemberStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest request) {

        if (request.getFirstName().isEmpty()
                || request.getLastName().isEmpty()
                || request.getEmail().isEmpty()
                || request.getPassword().isEmpty()) {

            throw new IllegalArgumentException("Member fields cannot be empty");
        }

        if (memberRepository.findByEmail(request.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        Member member = new Member();
        member.setFirstName(request.getFirstName());
        member.setLastName(request.getLastName());
        member.setEmail(request.getEmail());
        member.setPassword(request.getPassword());

        Member savedMember = memberRepository.save(member);

        CreateMemberResponse response = new CreateMemberResponse();
        response.setFullName(savedMember.getFirstName() + " " + savedMember.getLastName());
        response.setEmail(savedMember.getEmail());
        response.setPhone(savedMember.getPhone());
        response.setAddress(savedMember.getAddress());

        return response;
    }

    @Override
    public Member getMemberById(String id) {
        return null;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return null;
    }

    @Override
    public List<Member> getMembersByStatus(MemberStatus status) {
        return null;
    }

    @Override
    public List<Member> getAllMembers() {
        return null;
    }

    @Override
    public Member updateMember(Member member) {
        return null;
    }

    @Override
    public void deleteMember(String id) {
    }
}