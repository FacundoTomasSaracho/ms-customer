package facundosaracho.customer.persistence.entity;

import facundosaracho.customer.model.ClientType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "customer")
@Comment("Tabla que contiene la información de todos nuestros customers.")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    @Comment("Nombre del cliente")
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    @Comment("Email del cliente. El valor es opcional.")
    private @Email String email;

    @Column(name = "phone_number", length = 30, nullable = false)
    @Comment("Número de teléfono del cliente.")
    private String phoneNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Comment("Fecha de creación/registro del cliente.")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_type", length = 10, nullable = false)
    @Comment("Tipo de cliente (B2C/B2B)")
    private ClientType clientType;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
