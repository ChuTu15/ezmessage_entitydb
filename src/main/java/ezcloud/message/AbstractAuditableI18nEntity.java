package ezcloud.message;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractAuditableI18nEntity extends AbstractAuditableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028717291390099009L;

	public static final String LANGUAGE_VI = "vi";
	public static final String LANGUAGE_EN = "en";

	@Column(name = "languageCode", columnDefinition = "varchar(20)", nullable = false)
	private String languageCode;

	@Column(name = "title", columnDefinition = "varchar(250)", nullable = false)
	private String title;

	@Column(name = "description", columnDefinition = "text", nullable = true)
	private String description;
}
