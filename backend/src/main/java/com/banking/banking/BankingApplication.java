package com.banking.banking;

import com.banking.banking.enums.RoleType;
import com.banking.banking.model.Authority;
import com.banking.banking.repositories.AuthorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	@Bean
	CommandLineRunner initRoles(AuthorityRepository authorityRepository) {
		return args -> {
			List<RoleType> roles = List.of(RoleType.MANAGER_ROLE, RoleType.USER_ROLE);

			for (RoleType role : roles) {
				if (!authorityRepository.existsByAuthority(role)) {
					authorityRepository.save(new Authority(role));
				}
			}
		};
	}

}
