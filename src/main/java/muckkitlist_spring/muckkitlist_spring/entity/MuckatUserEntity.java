package muckkitlist_spring.muckkitlist_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "muckat_user")
@Getter
@Setter
@RequiredArgsConstructor
public class MuckatUserEntity {

    @Id
    @Column(name = "muckat_user_id")
    private String muckatUserId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "muckat_id")
    private MuckatListEntity muckatListEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "kakao_id")
    private UserInfoEntity userInfo;

    @Column(name = "room_master")
    private boolean room_master;

}
