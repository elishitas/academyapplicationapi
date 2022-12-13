package academyapplication.rest.models.repositories;

import academyapplication.rest.models.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity,Long> {
}
