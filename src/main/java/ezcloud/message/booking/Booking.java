package ezcloud.message.booking;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.hotel.Hotel;
import ezcloud.message.ota.OTA;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends AbstractAuditableEntity {

    @JoinColumn(name = "propertyId", columnDefinition = "binary(16)", nullable = true)
    private UUID propertyId;

    @Column(name = "propertyExternalCode", columnDefinition = "varchar(30)", nullable = true)
    private String propertyExternalCode;

    @Column(name = "propertyCode", columnDefinition = "varchar(300)", nullable = true)
    private String propertyCode;

    @Column(name = "propertyType", columnDefinition = "varchar(30)", nullable = true)
    private String propertyType;

    @Column(name = "externalBookingId", columnDefinition = "varchar(300)", nullable = false)
    private String externalBookingId;

    @Column(name = "bookingCode", columnDefinition = "varchar(30)", nullable = false)
    private String bookingCode;

    @Column(name = "bookingLinkCode", columnDefinition = "varchar(30)", nullable = true)
    private String bookingLinkCode;

    @Column(name = "otaBookingCode", columnDefinition = "varchar(50)", nullable = false)
    private String otaBookingCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otaId", nullable = true)
    private OTA ota;

    @Column(name = "otaCode", columnDefinition = "varchar(30)", nullable = true)
    private String otaCode;

    @Column(name = "arrival", columnDefinition = "datetime", nullable = false)
    private LocalDateTime arrival;

    @Column(name = "departure", columnDefinition = "datetime", nullable = false)
    private LocalDateTime departure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @Column(name = "bitUnmap", columnDefinition = "integer default 0", nullable = true)
    private Integer bitUnmap;

    @Column(name = "comment", columnDefinition = "text", nullable = true)
    private String comment;

    @Column(name = "languageCode", columnDefinition = "varchar(20)", nullable = true)
    private String languageCode;

    @Column(name = "currencyCode", columnDefinition = "varchar(20)", nullable = true)
    private String currencyCode;

    @Column(name = "currencyRate", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal currencyRate;

    @Column(name = "extra", columnDefinition = "text", nullable = true)
    private String extra;

    @Column(name = "bookingStatus", columnDefinition = "integer default 0", nullable = false)
    private int bookingStatus;

    @Column(name = "bookingName", columnDefinition = "varchar(200)", nullable = true)
    private String bookingName;

    @Column(name = "bookingAccount", columnDefinition = "varchar(200)", nullable = true)
    private String bookingAccount;

    @Column(name = "adults", columnDefinition = "smallint default 2", nullable = false)
    private short adults;

    @Column(name = "children", columnDefinition = "smallint default 0", nullable = false)
    private short children;

    @Column(name = "baby", columnDefinition = "smallint default 0", nullable = false)
    private short baby;

    @Column(name = "amount", columnDefinition = "decimal(22,2) default 0", nullable = false)
    private BigDecimal amount;

    @Column(name = "amountTax", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal amountTax;

    @Column(name = "promoCode", columnDefinition = "varchar(20)", nullable = true)
    private String promoCode;

    @Column(name = "cancellationBy", columnDefinition = "varchar(200)", nullable = true)
    private String cancellationBy;

    @Column(name = "cancellationReason", columnDefinition = "varchar(300)", nullable = true)
    private String cancellationReason;

    @Column(name = "cancellationType", columnDefinition = "integer default 0", nullable = false)
    private int cancellationType;

    @Column(name = "cancellationRules", columnDefinition = "varchar(300)", nullable = true)
    private String cancellationRules;

    @Column(name = "paymentRules", columnDefinition = "varchar(300)", nullable = true)
    private String paymentRules;

    @Column(name = "bookingChannel", columnDefinition = "varchar(50) default 'OTA'", nullable = false)
    private String bookingChannel;

    @Column(name = "isEarlyCheckin", columnDefinition = "bit default 0", nullable = false)
    private boolean isEarlyCheckin;

    @Column(name = "isHighFloor", columnDefinition = "bit default 0", nullable = false)
    private boolean isHighFloor;

    @Column(name = "isNoSmokingRoom", columnDefinition = "bit default 0", nullable = false)
    private boolean isNoSmokingRoom;

    @Column(name = "nights", columnDefinition = "integer default 0", nullable = false)
    private int nights;

    @Column(name = "otherNotes", columnDefinition = "text", nullable = true)
    private String otherNotes;

    @Column(name = "isOtherRequests", columnDefinition = "bit default 0", nullable = false)
    private boolean isOtherRequests;

    @Column(name = "usedServiceFee", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal usedServiceFee;

    @Column(name = "usedVAT", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal usedVAT;

    @Column(name = "username", columnDefinition = "varchar(50)", nullable = true)
    private String username;

    @Column(name = "payableAmount", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal payableAmount;

    @Column(name = "subTotal", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal subTotal;

    @Column(name = "bookingMethod", columnDefinition = "varchar(255)", nullable = true)
    private String bookingMethod;

    @Column(name = "gatewayCode", columnDefinition = "varchar(255)", nullable = true)
    private String gatewayCode;

    @Column(name = "appliedGiftCodeId", columnDefinition = "binary(16)", nullable = true)
    private String appliedGiftCodeId;

    @Column(name = "paymentData", columnDefinition = "text", nullable = true)
    private String paymentData;

    @Column(name = "commission", columnDefinition = "decimal(22,2)", nullable = true)
    private BigDecimal commission;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private Collection<BookingPayment> bookingPayments;
}