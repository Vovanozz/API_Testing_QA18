package dto;

import lombok.*;

import java.util.List;
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class GetALLContactsDTO {

    List<ContactDTO> contacts;
}
