package bmmf.turzimProje.model.dto;

import bmmf.turzimProje.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String username;
    private String password;
    private UserType userType;
    private String acentaName;
    private String personelName;
}
