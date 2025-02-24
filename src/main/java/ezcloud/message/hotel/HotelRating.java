package ezcloud.message.hotel;

import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRating extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelReviewId", nullable = false)
    private HotelReview hotelReview;

    @Column(name = "title", columnDefinition = "varchar(300)", nullable = true)
    private String title;

    @Column(name = "score", columnDefinition = "double default 0", nullable = true)
    private double score;

    @Column(name = "count", columnDefinition = "integer default 0", nullable = false)
    private int count;
}