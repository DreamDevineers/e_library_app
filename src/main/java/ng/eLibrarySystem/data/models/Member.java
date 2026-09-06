package ng.eLibrarySystem.data.models;

import lombok.Data;
import ng.eLibrarySystem.enums.MemberStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Member {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private MemberStatus status = MemberStatus.ACTIVE;
    private LocalDateTime createdAt = LocalDateTime.now();
}