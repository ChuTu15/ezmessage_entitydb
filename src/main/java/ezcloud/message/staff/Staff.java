package ezcloud.message.staff;

import ezcloud.message.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active <> 2")
public class Staff extends AbstractAuditableEntity {

    /**
     *
     */
    private static final long serialVersionUID = 7854177732276638304L;

    @Column(name = "staffCode", columnDefinition = "varchar(50)", nullable = true)
    private String staffCode;

    @Column(name = "staffAlias", columnDefinition = "nvarchar(300)", nullable = true)
    private String staffAlias;

    @Column(name = "fullname", columnDefinition = "varchar(100)", nullable = true)
    private String fullname;

    @Column(name = "username", columnDefinition = "varchar(100)", nullable = false)
    private String username;

    @Column(name = "password", columnDefinition = "varchar(250)", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId", nullable = false)
    private StaffGroup group;

    @Column(name = "email", columnDefinition = "varchar(100)", nullable = false)
    private String email;

    @Column(name = "gender", columnDefinition = "varchar(30)", nullable = true)
    private String gender;

    @Column(name = "phone", columnDefinition = "varchar(50)", nullable = true)
    private String phone;

    @Column(name = "address", columnDefinition = "varchar(300)", nullable = true)
    private String address;

    @Column(name = "position", columnDefinition = "varchar(200)", nullable = true)
    private String position;

    @Column(name = "isOwner", columnDefinition = "bit default 0", nullable = false)
    private boolean isOwner;

    @Column(name = "avatarUrl", columnDefinition = "varchar(300)", nullable = true)
    private String avatarUrl;

    @Column(name = "descriptionVi", columnDefinition = "varchar(250)", nullable = true)
    private String description;

    @Column(name = "ezUserId", columnDefinition = "varchar(300)", nullable = true)
    private String ezUserId;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
    private Set<StaffForGroup> staffForGroups;

}