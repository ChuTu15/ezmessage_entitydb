package ezcloud.message.review;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.booking.Customer;
import ezcloud.message.staff.Staff;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId", nullable = false)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staff;

    @Column(name = "content", columnDefinition = "text", nullable = true)
    private String content;

    @Column(name = "isProperty", columnDefinition = "bit(1) default 0", nullable = true)
    private boolean isProperty;
}