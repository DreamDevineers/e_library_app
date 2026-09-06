package ng.eLibrarySystem.data.repositories;

import ng.eLibrarySystem.data.models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataMongoTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;
    private Member member;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        member = new Member();
    }

    @Test
    void testEmptyRepository() {
        assertNull(repository);
    }

    @Test
    public void testCreateMember() {

        member.setFullName("Olukayode Kaynot");
        member.setEmail("kaynot@gmail.com");
        member.setPassword("password");
        member.setPhone("08012345678");
        member.setAddress("Lagos, Nigeria");

        Member savedMember = repository.save(member);

        assertNotNull(savedMember);
        assertNotNull(savedMember.getId());
    }
}