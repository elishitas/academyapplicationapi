package academyapplication.rest.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int celular;
}
