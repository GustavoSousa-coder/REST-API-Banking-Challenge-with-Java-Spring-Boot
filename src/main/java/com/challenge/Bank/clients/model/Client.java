package com.challenge.Bank.clients.model;

import com.challenge.Bank.Enums.ClientRoles;
import com.challenge.Bank.Enums.ClientStatus;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_clients")
public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "date_of_birth", nullable = false, length = 10)
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Setter(AccessLevel.NONE)
    @Column(name = "password", length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Setter(AccessLevel.PUBLIC)
    @Builder.Default
    @Column(name = "client_status", nullable = false, length = 10)
    private ClientStatus clientStatus = ClientStatus.ACTIVE;

    @Builder.Default
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ClientRoles role = ClientRoles.CLIENT;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == ClientRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_CLIENT"));
        else return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return  this.clientStatus != ClientStatus.BLOCKED &&
                this.clientStatus != ClientStatus.SUSPICIOUS;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.clientStatus == ClientStatus.ACTIVE;
    }
}