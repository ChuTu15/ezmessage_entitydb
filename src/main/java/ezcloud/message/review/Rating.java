package ezcloud.message.review;

import ezcloud.message.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId", nullable = false)
    private Review review;

    @Column(name = "title", columnDefinition = "varchar(300)", nullable = true)
    private String title;

    @Column(name = "score", columnDefinition = "double default 0", nullable = false)
    private double score;
}