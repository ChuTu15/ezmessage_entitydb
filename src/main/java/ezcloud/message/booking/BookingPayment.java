package ezcloud.message.booking;

import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active <> 2")
public class BookingPayment extends AbstractAuditableEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookingId", nullable = false)
	private Booking booking;

	@Column(name = "amount", columnDefinition = "decimal(22,2) default 0", nullable = false)
	private BigDecimal amount;

	@Column(name = "batchNo", columnDefinition = "varchar(250)", nullable = true)
	private String batchNo;

	@Column(name = "receiptNo", columnDefinition = "varchar(250)", nullable = true)
	private String receiptNo;

	@Column(name = "cardInfo", columnDefinition = "varchar(250)", nullable = true)
	private String cardInfo;

	@Column(name = "explanation", columnDefinition = "varchar(250)", nullable = true)
	private String explanation;

	@Column(name = "paymentType", columnDefinition = "integer default 0", nullable = false)
	private int paymentType;

	@Column(name = "paymentStatus", columnDefinition = "integer default 0", nullable = false)
	private int paymentStatus;

	@Column(name = "responseCode", columnDefinition = "varchar(250)", nullable = true)
	private String responseCode;

	@Column(name = "responseMessage", columnDefinition = "varchar(300)", nullable = true)
	private String responseMessage;

	@Column(name = "transactionRef", columnDefinition = "varchar(250)", nullable = true)
	private String transactionRef;

	@Column(name = "transactionDate", columnDefinition = "datetime", nullable = true)
	private LocalDateTime transactionDate;

	@Column(name = "transactionNo", columnDefinition = "varchar(250)", nullable = true)
	private String transactionNo;

	@Column(name = "currencyCode", columnDefinition = "varchar(20)", nullable = true)
	private String currencyCode;

	@Column(name = "appliedRate", columnDefinition = "decimal(22,2) default 1", nullable = true)
	private BigDecimal appliedRate;

	@Column(name = "note", columnDefinition = "varchar(300)", nullable = true)
	private String note;

	@Column(name = "paymentMethod", columnDefinition = "varchar(30)", nullable = true)
	private String paymentMethod;

	@Column(name = "paymentDeadline", columnDefinition = "datetime", nullable = true)
	private LocalDateTime paymentDeadline;

	@Column(name = "remind", columnDefinition = "tinyint default 0", nullable = false)
	private byte remindCount;

	@Column(name = "qrcode", columnDefinition = "text", nullable = true)
	private String qrcode;

	@Column(name = "ezpayRef", columnDefinition = "varchar(250)", nullable = true)
	private String ezpayRef;

	@Column(name = "pmsRef", columnDefinition = "varchar(300)", nullable = true)
	private String pmsRef;

	@Column(name = "times", columnDefinition = "tinyint default 1", nullable = false)
	private byte times;

	@Column(name = "isRemind", columnDefinition = "bit default 0", nullable = false)
	private boolean isRemind;
}