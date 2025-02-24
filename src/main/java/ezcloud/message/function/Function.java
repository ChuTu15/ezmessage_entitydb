package ezcloud.message.function;

import ezcloud.message.AbstractAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "function")
public class Function extends AbstractAuditableEntity {

    @Column(name = "functionCode", columnDefinition = "varchar(50)", nullable = false)
    private String functionCode;

    @Column(name = "nameVi", columnDefinition = "varchar(300)", nullable = false)
    private String nameVi;

    @Column(name = "descriptionVi", columnDefinition = "varchar(3000)")
    private String descriptionVi;

    @Column(name = "functionsLevel", columnDefinition = "varchar(300)")
    private String functionsLevel;

    @OneToMany(mappedBy = "functionsParent", fetch = FetchType.LAZY)
    private Set<Function> functionsParents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functionsParentId", nullable = false)
    private Function functionsParent;

}