package ezcloud.message.staff;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.domain.DomainStaffGroup;
import ezcloud.message.permission.PermissionStaffGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "staff_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffGroup extends AbstractAuditableEntity {

	/**
	 * 
	 */

	public static final String TYPE_USER = "USER";
	public static final String TYPE_ADMIN = "ADMIN";
	public static final String TYPE_SUPPER_ADMIN = "SUPPER_ADMIN";
	private static final long serialVersionUID = 5589151053185385341L;

	@Column(name = "staffGroupCode", columnDefinition = "varchar(50)", nullable = false)
	private String staffGroupCode;

	@Column(name = "nameVi", columnDefinition = "varchar(300)", nullable = false)
	private String nameVi;

	@Column(name = "staffGroupType", columnDefinition = "varchar(50)", nullable = true)
	private String staffGroupType;

	@Column(name = "descriptionVi", columnDefinition = "varchar(500)", nullable = true)
	private String descriptionVi;

	@Column(name = "defaultApp", columnDefinition = "varchar(50)", nullable = false)
	private String defaultApp;

	@OneToMany(mappedBy = "staffGroup", fetch = FetchType.LAZY)
	private Set<StaffForGroup> staffForGroups;

	@OneToMany(mappedBy = "staffGroup", fetch = FetchType.LAZY)
	private Set<PermissionStaffGroup> permissionStaffGroups;

	@OneToMany(mappedBy = "staffGroup", fetch = FetchType.LAZY)
	private Set<DomainStaffGroup> domainStaffGroups;

}