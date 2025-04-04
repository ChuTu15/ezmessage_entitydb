package ezcloud.message.permission;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.function.Function;
import ezcloud.message.hotel.Hotel;
import ezcloud.message.staff.Staff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "permission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends AbstractAuditableEntity {

    /**
     *
     */
    private static final long serialVersionUID = -3143037792566120040L;

    public static final byte CREATE = 0;
    public static final byte UPDATE = 1;
    public static final byte VIEW = 2;
    public static final byte DELETE = 3;
    public static final byte APPROVE = 4;

    public static final String LEVEL_USER = "USER";
    public static final String LEVEL_ADMIN = "ADMIN";
    public static final String LEVEL_SUPPER_ADMIN = "SUPPER_ADMIN";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functionsId", nullable = false)
    private Function function;

    @Column(name = "permissionCode", columnDefinition = "varchar(50)", nullable = false)
    private String permissionCode;

    @Column(name = "nameVi", columnDefinition = "varchar(300)", nullable = false)
    private String nameVi;

    @Column(name = "permissionLevel", columnDefinition = "varchar(300)", nullable = false)
    private String level;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    private Set<PermissionStaffGroup> permissionStaffGroups;

}