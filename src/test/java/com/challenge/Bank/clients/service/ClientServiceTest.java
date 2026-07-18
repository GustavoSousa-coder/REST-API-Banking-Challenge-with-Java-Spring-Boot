package com.challenge.Bank.clients.service;

import com.challenge.Bank.Enums.ClientStatus;
import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.clients.mapper.ClientMapper;
import com.challenge.Bank.clients.model.Client;
import com.challenge.Bank.clients.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest  {

    @Mock
    private ClientRepository repository;

    @Mock
    private ClientMapper mapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private ClientService service;

    private UUID uuid;

    private Client client;

    private ClientRequestDTO request;

    private ClientResponseDTO response;

    @BeforeEach
    void setup() {

        uuid = UUID.randomUUID();

        request = new ClientRequestDTO(
                "Luis Gustavo",
                "12345678909",
                LocalDate.now().minusYears(20),
                "luis@email.com",
                "Senha@123"
        );

        client = Client.builder()
                .uuid(uuid)
                .name(request.name())
                .cpf(request.cpf())
                .dateOfBirth(request.dateOfBirth())
                .email(request.email())
                .password("encoded")
                .build();

        response = new ClientResponseDTO(
                uuid,
                request.name(),
                request.dateOfBirth(),
                request.email(),
                ClientStatus.ACTIVE
        );
    }

    @Test
    void shouldSaveClientSuccessfully() {

        when(repository.findByCpf(request.cpf()))
                .thenReturn(Optional.empty());

        when(repository.findByEmail(request.email()))
                .thenReturn(Optional.empty());

        when(passwordEncoder.encode(request.password()))
                .thenReturn("encoded");

        when(mapper.toEntity(request, "encoded"))
                .thenReturn(client);

        when(repository.save(client))
                .thenReturn(client);

        when(mapper.toDTO(client))
                .thenReturn(response);

        ClientResponseDTO result = service.save(request);

        assertNotNull(result);

        assertEquals(response.uuid(), result.uuid());

        assertEquals(response.email(), result.email());

        verify(repository).findByCpf(request.cpf());

        verify(repository).findByEmail(request.email());

        verify(passwordEncoder).encode(request.password());

        verify(repository).save(client);

    }

}
