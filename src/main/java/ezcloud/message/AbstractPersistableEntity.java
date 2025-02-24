package ezcloud.message;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPersistableEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3748916308885291781L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "binary(16)")
	private UUID id;

	@Version
	@Column(name = "version", columnDefinition = "bigint default 0", nullable = false)
	private long version;
}
