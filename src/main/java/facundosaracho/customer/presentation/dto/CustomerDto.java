package facundosaracho.customer.presentation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import facundosaracho.customer.model.ClientType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CustomerDto(Long id,
                          @NotBlank String name,
                          @NotBlank @Email String email,
                          @NotBlank String phoneNumber,
                          @NotBlank ClientType clientType,
                          @FutureOrPresent @NotNull LocalDateTime createdAt) {


}
