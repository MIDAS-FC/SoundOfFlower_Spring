package midas.SoundOfFlower.entity.music;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Builder
@Table(name = "DELIGHT_MUSIC")
@AllArgsConstructor
public class DelightMusic {

    @Id
    @Column(name = "spotify", insertable = false, updatable = false, nullable = false)
    private String spotify;

    @Column(name = "emotion_type", insertable = false, updatable = false, nullable = false)
    private String emotionType;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "spotify", referencedColumnName = "spotify"),
            @JoinColumn(name = "emotion_type", referencedColumnName = "emotion_type")
    })
    private Music music;

    private Double delight;
    private Double love;
    private Double sad;
}
