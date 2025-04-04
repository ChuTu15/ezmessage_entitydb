package ezcloud.message.domain;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.hotel.Hotel;
import ezcloud.message.permission.Permission;
import ezcloud.message.staff.StaffGroup;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "domain_staff_group")
public class DomainStaffGroup extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffGroupId", nullable = false)
    private StaffGroup staffGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    @JoinColumn(name = "chainId", nullable = false)
    private UUID chainId;

}