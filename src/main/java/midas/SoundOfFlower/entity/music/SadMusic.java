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
@Table(name = "SAD_MUSIC")
@AllArgsConstructor
public class SadMusic {

    @Id
    @Column(name = "spotify", insertable = false, updatable = false, nullable = false, length = 30)
    private String spotify;

    @Column(name = "emotion_type", insertable = false, updatable = false, nullable = false, length = 10)
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
