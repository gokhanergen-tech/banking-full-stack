package com.banking.banking.model;

import com.banking.banking.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = false, unique = true, length = 20)
    private RoleType authority;

    public Authority(RoleType authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.name();
    }
}
