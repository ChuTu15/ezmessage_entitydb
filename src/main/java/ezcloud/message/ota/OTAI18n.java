package ezcloud.message.ota;

import ezcloud.message.AbstractAuditableI18nEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;

@Entity
@Table(name = "ota_i18n")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active <> 2")
public class OTAI18n extends AbstractAuditableI18nEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7792586608161176972L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "otaId", nullable = false)
	private OTA ota;

	@Column(name = "alias", columnDefinition = "varchar(250)", nullable = true)
	private String alias;

	@Column(name = "credentials", columnDefinition = "text", nullable = true)
	private String credentials;

	@Column(name = "instruction", columnDefinition = "text", nullable = true)
	private String instruction;
}