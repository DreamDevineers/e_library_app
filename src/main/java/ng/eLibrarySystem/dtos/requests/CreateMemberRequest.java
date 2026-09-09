package ng.eLibrarySystem.dtos.requests;

import lombok.Data;

@Data
public class CreateMemberRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
}