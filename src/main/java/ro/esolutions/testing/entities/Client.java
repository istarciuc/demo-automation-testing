package ro.esolutions.testing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private Type type;


    public enum Type {
        OLD, YOUNG
    }

}
