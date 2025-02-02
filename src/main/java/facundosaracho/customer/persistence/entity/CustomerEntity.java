package facundosaracho.customer.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private @Email String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "created_at",  nullable = false)
    private LocalDateTime createdAt;
}
