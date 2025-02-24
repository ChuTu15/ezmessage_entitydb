package ezcloud.message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity extends AbstractPersistableEntity {

	/**
	 *  
	 */
	private static final long serialVersionUID = 86922363434742876L;

	/**
	 * Mark entity as no longer a candiate in any business logic
	 */
	public static final byte ACTIVE_STATUS_INACTIVE = 0;
	/**
	 * Mark entity as candiate to apply in business logic
	 */
	public static final byte ACTIVE_STATUS_ACTIVE = 1;
	/**
	 * Mark entity as soft-delete and the object will be never be found again in any code.
	 * Entity in this state usually filter from JPA and only ascessble by native SQL
	 */
	public static final byte ACTIVE_STATUS_DELETED = 2;
	/**
	 * Mark object are success pushed to external party as OTA or CMS
	 * After this state then entity only become delete. Another transition can cause unexpected behavior.
	 */
	public static final byte ACTIVE_STATUS_PUBLISH = 3;
	/**
	 * Mark object are failed when pushed to external party as OTA or CMS
	 * <i>When it was {@link AbstractAuditableEntity.ACTIVE_STATUS_PUBLISH} then it shouldn't be back to this stage.
	 */
    public static final byte ACTIVE_STATUS_FAILED_TO_PUBLISH = 4;

	@Column(name = "sortIndex", columnDefinition = "integer default 0", nullable = false)
	private int sortIndex;

	@Column(name = "active", columnDefinition = "tinyint default 0", nullable = false)
	private byte active;

	@Column(name = "createdDate", columnDefinition = "datetime", updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "createdBy", columnDefinition = "binary(16)", updatable = false)
	@CreatedBy
	private UUID createdBy;

	@Column(name = "updatedDate", columnDefinition = "datetime")
	private LocalDateTime updatedDate;

	@Column(name = "updatedBy", columnDefinition = "binary(16)")
	@LastModifiedBy
	private UUID updatedBy;

    @PrePersist
    public void touchForCreate() {
		if (createdDate == null) {
			createdDate = LocalDateTime.now(ZoneOffset.UTC);
		}
		if (updatedDate == null) {
			updatedDate = createdDate;
		}
    }

    @PreUpdate
    public void touchForUpdate() {
		updatedDate = LocalDateTime.now(ZoneOffset.UTC);
    }
	public boolean isActive() {
		return active == ACTIVE_STATUS_ACTIVE;
	}

	public boolean isDeleted() {
		return active == ACTIVE_STATUS_DELETED;
	}
}
