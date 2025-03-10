package ezcloud.message.hotel;

import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends AbstractAuditableEntity {

    @Column(name = "externalCode", columnDefinition = "varchar(300)", nullable = true)
    private String externalCode;

    @Column(name = "externalHotelId", columnDefinition = "varchar(300)", nullable = true)
    private String externalHotelId;

    @Column(name = "hotelCode", columnDefinition = "varchar(30)", nullable = false)
    private String hotelCode;

    @Column(name = "nameVi", columnDefinition = "varchar(250)", nullable = false)
    private String nameVi;

    @Column(name = "addressVi", columnDefinition = "varchar(300)", nullable = false)
    private String addressVi;

    @Column(name = "cityVi", columnDefinition = "varchar(200)", nullable = false)
    private String cityVi;

    @Column(name = "countryVi", columnDefinition = "varchar(200)", nullable = false)
    private String countryVi;

    @Column(name = "email", columnDefinition = "varchar(300)", nullable = false)
    private String email;

    @Column(name = "phone", columnDefinition = "varchar(100)", nullable = false)
    private String phone;

    @Column(name = "descriptionVi", columnDefinition = "text", nullable = true)
    private String descriptionVi;

    @JoinColumn(name = "logoUrl", nullable = true)
    private String logoUrl;

    @JoinColumn(name = "defaultImageUrl", nullable = true)
    private String defaultImageUrl;

    @JoinColumn(name = "isAutoReply", nullable = true)
    private Boolean isAutoReply;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private Set<HotelI18n> hotelI18n;


    public Optional<HotelI18n> getI18n(String langCode) {

        return this.getHotelI18n() == null ? Optional.empty()
                : this.getHotelI18n().parallelStream().filter(i18n -> i18n.getLanguageCode().equalsIgnoreCase(langCode))
                .findFirst();
    }

    public String getTitle(String langeCode) {
        return this.getI18n(langeCode).map(HotelI18n::getTitle).orElse(this.nameVi);
    }
}