package ezcloud.message.ota;

import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ota_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OTAGroup extends AbstractAuditableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1966166682741564601L;

	@Column(name = "otaGroupCode", columnDefinition = "varchar(50)", nullable = true)
	private String otaGroupCode;

	@Column(name = "titleVi", columnDefinition = "varchar(200)", nullable = false)
	private String titleVi;

	@Column(name = "descriptionVi", columnDefinition = "text", nullable = true)
	private String descriptionVi;

	@OneToMany(mappedBy = "otaGroup", fetch = FetchType.LAZY)
	private Set<OTAGroupI18n> otaGroupI18n;

	@OneToMany(mappedBy = "otaGroup", fetch = FetchType.LAZY)
	private Set<OTA> ota;
}