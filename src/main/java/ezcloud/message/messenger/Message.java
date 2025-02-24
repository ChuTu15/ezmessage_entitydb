package ezcloud.message.messenger;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.booking.Customer;
import ezcloud.message.staff.Staff;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversationId", nullable = false)
    private Conversation conversation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = true)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", nullable = true)
    private Staff staff;

    @Column(name = "externalMessageCode", columnDefinition = "varchar(300)", nullable = true)
    private String externalMessageCode;

    @Column(name = "content", columnDefinition = "varchar(500)", nullable = true)
    private String content;

    @Column(name = "contentType", columnDefinition = "varchar(50)", nullable = true)
    private String contentType;

    @Column(name = "isProperty", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isProperty;

    @Column(name = "isRead", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isRead;
}