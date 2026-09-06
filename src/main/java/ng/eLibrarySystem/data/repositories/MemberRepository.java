package ng.eLibrarySystem.data.repositories;

import ng.eLibrarySystem.data.models.Member;
import ng.eLibrarySystem.enums.MemberStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {

    Member findByEmail(String email);
    List<Member> findByStatus(MemberStatus status);
}