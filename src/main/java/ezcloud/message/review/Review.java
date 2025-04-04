package ezcloud.message.review;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.booking.Customer;
import ezcloud.message.booking.Booking;
import ezcloud.message.messenger.Message;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review extends AbstractAuditableEntity {

    @Column(name = "propertyId", columnDefinition = "binary(16)", nullable = false)
    private UUID propertyId;

    @Column(name = "propertyType", columnDefinition = "varchar(30)", nullable = false)
    private String propertyType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId", nullable = false)
    private Booking booking;

    @Column(name = "bookingCode", columnDefinition = "varchar(30)", nullable = false)
    private String bookingCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @Column(name = "customerCode", columnDefinition = "varchar(100)", nullable = true)
    private String customerCode;

    @Column(name = "externalReviewCode", columnDefinition = "varchar(100)", nullable = true)
    private String externalReviewCode;

    @Column(name = "isHidden", columnDefinition = "bit(1) default 0", nullable = true)
    private boolean isHidden;

    @Column(name = "isExpired", columnDefinition = "bit(1) default 0", nullable = true)
    private boolean isExpired;

    @Column(name = "title", columnDefinition = "varchar(300)", nullable = true)
    private String title;

    @Column(name = "overallScore", columnDefinition = "double default 0", nullable = true)
    private double overallScore;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private Set<Rating> ratings;
}
