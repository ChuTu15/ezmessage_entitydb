package ezcloud.message.staff;

import ezcloud.message.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "staff_for_group")
public class StaffForGroup extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffGroupId")
    private StaffGroup staffGroup;

    @Column(name = "descriptionVi", columnDefinition = "varchar(500)")
    private String descriptionVi;

}