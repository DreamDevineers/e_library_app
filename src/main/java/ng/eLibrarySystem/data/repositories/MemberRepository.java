package ng.eLibrarySystem.data.repositories;

import ng.eLibrarySystem.data.models.Member;
import ng.eLibrarySystem.enums.MemberStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member,String> {
    Member save(String id, Member member);
    List<Member> findAll();
    Optional<Member> findById(String id);
    Member findMemberByEmail(String email);
    List<Member> findByStatus(MemberStatus status);
    void disable(String id);
    void enable(String id);
    List<Member> findActive();
}
