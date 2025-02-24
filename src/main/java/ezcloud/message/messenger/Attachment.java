package ezcloud.message.messenger;

import ezcloud.message.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "attachment")
public class Attachment extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "messageId", nullable = false)
    private Message message;

    @Column(name = "fileName", columnDefinition = "varchar(255)", nullable = false)
    private String fileName;

    @Column(name = "fileExtension", columnDefinition = "varchar(100)", nullable = false)
    private String fileExtension;

    @Column(name = "fileURL", columnDefinition = "varchar (500)", nullable = true)
    private String fileURL;

    @Column(name = "size", columnDefinition = "integer default 0", nullable = true)
    private int size;

    @Column(name = "sizeUnit", columnDefinition = "varchar (30)", nullable = true)
    private String sizeUnit;
}