package ma.xproce.modelmapperdemo.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CustomerDtoNew {
    private String name;
    private String email;
    private String password;
}
