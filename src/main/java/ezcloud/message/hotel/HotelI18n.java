package ezcloud.message.hotel;

import ezcloud.message.AbstractAuditableI18nEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_i18n")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active <> 2")
public class HotelI18n extends AbstractAuditableI18nEntity {

    /**
     *
     */
    private static final long serialVersionUID = 8669257912706550382L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    @Column(name = "address", columnDefinition = "varchar(300)", nullable = false)
    private String address;

    @Column(name = "city", columnDefinition = "varchar(200)", nullable = false)
    private String city;

    @Column(name = "country", columnDefinition = "varchar(200)", nullable = false)
    private String country;

    @Column(name = "location", columnDefinition = "varchar(300)", nullable = true)
    private String location;

    @Column(name = "area", columnDefinition = "varchar(100)", nullable = true)
    private String area;
}