package muckkitlist_spring.muckkitlist_spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "review_image")
@Data
@RequiredArgsConstructor
public class ReviewImageEntity {
    @Id
    @Column(name = "image_id")
    private String imageId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_review_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserReviewEntity userReviewEntity;


    @Column(name= "timestamp")
    private LocalDate timestamp;
}
