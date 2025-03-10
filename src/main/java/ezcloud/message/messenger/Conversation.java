package ezcloud.message.messenger;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.booking.Booking;
import ezcloud.message.booking.Customer;
import ezcloud.message.ota.OTA;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "conversation")
public class Conversation extends AbstractAuditableEntity {

    @Column(name = "lastMessageId", columnDefinition = "binary(16)", nullable = true)
    private UUID lastMessageId;

    @Column(name = "propertyId", columnDefinition = "binary(16)", nullable = false)
    private UUID propertyId;

    @Column(name = "propertyType", columnDefinition = "varchar(30)", nullable = false)
    private String propertyType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId", nullable = true)
    private Booking booking;

    @Column(name = "bookingCode", columnDefinition = "varchar(30)", nullable = true)
    private String bookingCode;

    @Column(name = "externalConversationCode", columnDefinition = "varchar(300)", nullable = true)
    private String externalConversationCode;

    @Column(name = "saolaAIConversationCode", columnDefinition = "varchar(300)", nullable = true)
    private String saolaAIConversationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otaId", nullable = true)
    private OTA otaId;

    @Column(name = "customerCode", columnDefinition = "varchar(100)", nullable = true)
    private String customerCode;

    @Column(name = "isClosed", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isClosed;

    @OneToMany(mappedBy = "conversation", fetch = FetchType.LAZY)
    private Set<Message> messages;

    @OneToMany(mappedBy = "conversation", fetch = FetchType.LAZY)
    private Set<Note> notes;
}