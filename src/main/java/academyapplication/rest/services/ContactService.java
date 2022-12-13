package academyapplication.rest.services;

import academyapplication.rest.models.domain.ContactDTO;
import academyapplication.rest.models.domain.NewContactDTO;
import academyapplication.rest.models.entities.ContactEntity;
import academyapplication.rest.models.mappers.ContactMapper;
import academyapplication.rest.models.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository,
                          ContactMapper contactMapper){
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public ContactDTO findById(long id){
        return Optional.ofNullable(id)
                .map(ID-> contactRepository.findById(ID).get())
                .map(entity -> contactMapper.contactEntityToContactDTO(entity))
                .orElse(new ContactDTO());
    }

    public NewContactDTO add(ContactDTO contactDTO){
        return Optional.ofNullable(contactDTO)
                .map(dto -> contactMapper.contactDTOToContactEntity(contactDTO))
                .map(entity -> contactRepository.save(entity))
                .map(entity -> contactMapper.contactEntityToNewContactDTO(entity))
                .orElse(new NewContactDTO());
    }

    public int delete(Long id){
        Optional<Long> ID = Optional.ofNullable(id);

        if(ID.isEmpty())
            return 0;

        Optional<ContactEntity> entity = contactRepository.findById(id);
        if(entity.isEmpty())
            return 0;

        contactRepository.delete(entity.get());

        return 1;
    }

    public  ContactDTO update(ContactDTO contactDTO){
        Optional<ContactEntity> optionalEntity = contactRepository.findById(contactDTO.getId());

        if (optionalEntity.isEmpty())
            return  new ContactDTO();

        ContactEntity entity = optionalEntity.get();

        entity.setNombre(contactDTO.getNombre());
        entity.setCelular(contactDTO.getCelular());

        contactRepository.save(entity);

        return contactDTO;
    }
}
