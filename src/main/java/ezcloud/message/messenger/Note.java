package ezcloud.message.messenger;

import ezcloud.message.AbstractAuditableEntity;
import ezcloud.message.staff.Staff;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "note")
public class Note extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversationId", nullable = false)
    private Conversation conversation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staff;

    @Column(name = "title", columnDefinition = "varchar(300)", nullable = true)
    private String title;

    @Column(name = "content", columnDefinition = "text", nullable = true)
    private String content;
}