package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountId.class)
@Getter
@Setter
@AllArgsConstructor
public class Account {
    @Id
    private String accountNumber;

    @Id
    private String accountType;

    private String name;
}