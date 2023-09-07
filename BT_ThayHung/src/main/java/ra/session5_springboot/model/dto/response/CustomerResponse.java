package ra.session5_springboot.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerResponse {
    private Long id;
    private String fullName;
    private int age;
    private boolean sex;
    private  String email;
    private  String phoneNumber;
}
