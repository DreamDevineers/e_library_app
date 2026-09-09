package ng.eLibrarySystem.services;

import ng.eLibrarySystem.data.models.Member;
import ng.eLibrarySystem.dtos.requests.CreateMemberRequest;
import ng.eLibrarySystem.dtos.responses.CreateMemberResponse;
import ng.eLibrarySystem.enums.MemberStatus;

import java.util.List;

public interface MemberService {

    CreateMemberResponse createMember(CreateMemberRequest request);

    Member getMemberById(String id);

    Member getMemberByEmail(String email);

    List<Member> getMembersByStatus(MemberStatus status);

    List<Member> getAllMembers();

    Member updateMember(Member member);

    void deleteMember(String id);
}