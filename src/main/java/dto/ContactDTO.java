package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class ContactDTO {
    /*
     {
      "id": "string",
      "name": "string",
      "lastName": "string",
      "email": "string",
      "phone": "6202026641",
      "address": "string",
      "description": "string"
    }
     */
   String id;
   String name;
   String lastName;
   String email;
   String phone;
   String address;
   String description;

}
