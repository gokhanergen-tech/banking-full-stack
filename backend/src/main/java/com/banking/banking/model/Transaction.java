package com.banking.banking.model;

import com.banking.banking.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "from_account_id",
            foreignKey = @ForeignKey(
                    name = "fk_transaction_from_account",
                    foreignKeyDefinition = "FOREIGN KEY (from_account_id) REFERENCES accounts(id) ON DELETE SET NULL"
            )
    )
    private Account from;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "to_account_id",
            foreignKey = @ForeignKey(
                    name = "fk_transaction_to_account",
                    foreignKeyDefinition = "FOREIGN KEY (to_account_id) REFERENCES accounts(id) ON DELETE SET NULL"
            )
    )
    private Account to;

    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime transactionDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;
}
