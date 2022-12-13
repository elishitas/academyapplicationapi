package academyapplication.rest.models.mappers;

import academyapplication.rest.models.domain.ContactDTO;
import academyapplication.rest.models.domain.NewContactDTO;
import academyapplication.rest.models.entities.ContactEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactMapper {

    public ContactEntity contactDTOToContactEntity(ContactDTO contactDTO){
        ContactEntity contact = new ContactEntity();
        contact.setNombre(contactDTO.getNombre());
        contact.setCelular(contactDTO.getCelular());

        return contact;
    }

    public ContactDTO contactEntityToContactDTO(ContactEntity contactEntity){
        return Optional
                .ofNullable(contactEntity)
                .map(entity -> new ContactDTO(
                        contactEntity.getId(),
                        contactEntity.getNombre(),
                        contactEntity.getCelular())
                )
                .orElse(new ContactDTO());
    }

    public NewContactDTO contactEntityToNewContactDTO(ContactEntity contactEntity){
        return Optional
                .ofNullable(contactEntity)
                .map(entity -> new NewContactDTO(
                        contactEntity.getId())
                )
                .orElse(new NewContactDTO());
    }
}
