package academyapplication.rest.models.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewContactDTO {
    long id;
    String mensaje = "añadido exitosamente";

    public NewContactDTO(long id){
        this.id = id;
    }
}
