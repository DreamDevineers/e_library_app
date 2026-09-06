package ng.eLibrarySystem.data.repositories;

import ng.eLibrarySystem.data.models.Member;
import ng.eLibrarySystem.enums.MemberStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {

    Optional<Member> findByEmail(String email);
    List<Member> findByStatus(MemberStatus status);
    List<Member> findByStatusNot(MemberStatus status);
}