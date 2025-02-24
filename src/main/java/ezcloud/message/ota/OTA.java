package ezcloud.message.ota;

import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "ota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OTA extends AbstractAuditableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7906081189807117359L;

	public static final int INTERNATIONAL = 0;
	public static final int DOMESTIC = 1;

	public static final String NONE = "NONE";
	public static final String OTAGATEWAY = "OTAGateway";
	public static final String VNTRIP = "VNTRIP";
	public static final String SU = "SU";
	public static final String CHANNEX = "CHANNEX";
	public static final String HOTELBEDS = "HOTELBEDS";
	public static final String SABRE = "SABRE";
	public static final String TRAVELGATEX = "TRAVELGATEX";
	public static final String SITEMINDER = "SITEMINDER";
	public static final String ONEINVENTORY = "1i";
	public static final String ONEINVENTORYCONNECTION = "ONEINVENTORY";

	public static final int OAUTH = 3;
	public static final int MANUAL = 1;

	@Column(name = "otaCode", columnDefinition = "varchar(30)", nullable = false)
	private String otaCode;

	@Column(name = "code", columnDefinition = "varchar(300)", nullable = false)
	private String code;

	@Column(name = "nameVi", columnDefinition = "varchar(250)", nullable = false)
	private String nameVi;

	@Column(name = "aliasVi", columnDefinition = "varchar(250)", nullable = true)
	private String aliasVi;

	@Column(name = "otaType", columnDefinition = "integer default 0", nullable = false)
	private int otaType;

	@Column(name = "connection", columnDefinition = "varchar(50)", nullable = false)
	private String connection;

	@Column(name = "connectionType", columnDefinition = "integer default 0", nullable = false)
	private int connectionType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "otaGroupId", nullable = false)
	private OTAGroup otaGroup;

	@Column(name = "credentialsVi", columnDefinition = "text", nullable = true)
	private String credentialsVi;

	@Column(name = "instructionVi", columnDefinition = "text", nullable = true)
	private String instructionVi;

	@Column(name = "descriptionVi", columnDefinition = "varchar(300)", nullable = true)
	private String descriptionVi;

	@OneToMany(mappedBy = "ota", fetch = FetchType.LAZY)
	private Set<OTAI18n> otaI18n;

	public Optional<OTAI18n> getI18n(String langCode) {

		return this.getOtaI18n() == null ? Optional.empty()
				: this.getOtaI18n().parallelStream().filter(i18n -> i18n.getLanguageCode().equalsIgnoreCase(langCode))
						.findFirst();
	}

	public String getTitle(String langeCode) {
		return this.getI18n(langeCode).map(OTAI18n::getTitle).orElse(this.nameVi);
	}
}