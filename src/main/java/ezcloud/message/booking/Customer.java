package ezcloud.message.booking;

import ezcloud.message.AbstractAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AbstractAuditableEntity {

    /**
     *
     */
    private static final long serialVersionUID = 2077359320924875652L;

    @Column(name = "customerCode", columnDefinition = "varchar(100)", nullable = true)
    private String customerCode;

    @Column(name = "customerAlias", columnDefinition = "varchar(100)", nullable = true)
    private String customerAlias;

    @Column(name = "firstName", columnDefinition = "varchar(100)", nullable = false)
    private String firstName;

    @Column(name = "lastName", columnDefinition = "varchar(100)", nullable = true)
    private String lastName;

    @Column(name = "title", columnDefinition = "varchar(50)", nullable = true)
    private String title;

    @Column(name = "gender", columnDefinition = "varchar(30)", nullable = true)
    private String gender;

    @Column(name = "email", columnDefinition = "varchar(100)", nullable = true)
    private String email;

    @Column(name = "phone", columnDefinition = "varchar(50)", nullable = true)
    private String phone;

    @Column(name = "countryCode2", columnDefinition = "varchar(30)", nullable = true)
    private String countryCode2;

    @Column(name = "countryCode3", columnDefinition = "varchar(30)", nullable = true)
    private String countryCode3;

    @Column(name = "birthdate", columnDefinition = "datetime", nullable = true)
    private LocalDateTime birthdate;

    @Column(name = "identity", columnDefinition = "varchar(100)", nullable = true)
    private String identity;

    @Column(name = "companyName", columnDefinition = "varchar(300)", nullable = true)
    private String companyName;

    @JoinColumn(name = "propertyId", nullable = false)
    private UUID propertyId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "customerType", columnDefinition = "smallint(1) default 0", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Booking> bookings;
}