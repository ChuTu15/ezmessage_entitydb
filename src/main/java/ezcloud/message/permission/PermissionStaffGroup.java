package ezcloud.message.permission;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.staff.StaffGroup;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "permission_staff_group")
public class PermissionStaffGroup extends AbstractAuditableEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffGroupId", nullable = false)
    private StaffGroup staffGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permissionId")
    private Permission permission;

}