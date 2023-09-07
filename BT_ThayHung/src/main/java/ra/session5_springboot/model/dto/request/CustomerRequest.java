package ra.session5_springboot.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerRequest {
    @NotNull(message = "Not Null")
    private String fullName;
    @Min(value = 18 , message = "Age must be between 18 and 100")
    @Max(value = 100, message = "Age must be between 18 and 100")
    private int age;
    private boolean sex;
    @Pattern(regexp = "^(.+)@(\\S+)$",message = "Email is not valid")
    private  String email;
    @Pattern(regexp = "^0\\d{9,10}$" , message = "Phone number is not valid")
    private  String phoneNumber;
}
