package ezcloud.message.hotel;

import ezcloud.message.ota.OTA;
import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelReview extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otaId", nullable = false)
    private OTA ota;

    @Column(name = "otaCode", columnDefinition = "varchar(300)", nullable = true)
    private String otaCode;

    @Column(name = "overallScore", columnDefinition = "double default 0", nullable = true)
    private double overallScore;

    @Column(name = "overallCount", columnDefinition = "integer default 0", nullable = false)
    private int overallCount;
}