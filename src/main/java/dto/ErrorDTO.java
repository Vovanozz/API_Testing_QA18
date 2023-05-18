package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor

public class ErrorDTO {

    /*
    {
  "timestamp": "2023-05-16T16:08:24.753Z",
  "status": 0,
  "error": "string",
  "message": {},
  "path": "string"
}
     */

    int status;
    String error;
    String message;
}
