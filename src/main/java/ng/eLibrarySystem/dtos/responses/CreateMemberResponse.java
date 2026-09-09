package ng.eLibrarySystem.dtos.responses;

import lombok.Data;

@Data
public class CreateMemberResponse {

    private String fullName;
    private String email;
    private String phone;
    private String address;
}