package ng.eLibrarySystem.services;

import ng.eLibrarySystem.data.repositories.MemberRepository;
import ng.eLibrarySystem.dtos.requests.CreateMemberRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void testEmptyFields() {
        CreateMemberRequest request = new CreateMemberRequest();

        request.setFirstName("");
        request.setLastName("");
        request.setEmail("");
        request.setPassword("");

        assertThrows(IllegalArgumentException.class, () -> {
            memberService.createMember(request);
        });
    }

    @Test
    void testCreateMemberWithSameEmail() {

        CreateMemberRequest firstRequest = new CreateMemberRequest();

        firstRequest.setFirstName("Kayode");
        firstRequest.setLastName("Kay");
        firstRequest.setEmail("kaynot@gmail.com");
        firstRequest.setPassword("password");

        memberService.createMember(firstRequest);

        CreateMemberRequest secondRequest = new CreateMemberRequest();

        secondRequest.setFirstName("Another");
        secondRequest.setLastName("Member");
        secondRequest.setEmail("kaynot@gmail.com");
        secondRequest.setPassword("password");

        assertThrows(IllegalArgumentException.class, () -> {
            memberService.createMember(secondRequest);
        });
    }
}