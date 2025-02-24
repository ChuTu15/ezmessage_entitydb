package ezcloud.message.ota;

import ezcloud.message.AbstractAuditableI18nEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ota_group_i18n")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OTAGroupI18n extends AbstractAuditableI18nEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6523433208516640430L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "otaGroupId", nullable = false)
	private OTAGroup otaGroup;
}