package midas.SoundOfFlower.entity.music;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import midas.SoundOfFlower.entity.diary.Diary;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Builder
@Table(name = "MUSIC")
@AllArgsConstructor
public class Music {

    @Id
    @Column(name = "spotify", unique = true, nullable = false,length = 30)
    private String spotify;

    @Column(name = "emotion_type", nullable = false)
    private String emotionType;

    private Double totalLikes;

    @OneToMany(mappedBy = "music")
    private List<Diary> diary = new ArrayList<>();

    @OneToMany(mappedBy = "music", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MusicLike> musicLikes = new ArrayList<>();

    @OneToOne(mappedBy = "music", cascade = CascadeType.ALL)
    private LoveMusic loveMusic;

    @OneToOne(mappedBy = "music", cascade = CascadeType.ALL)
    private SadMusic sadMusic;

    @OneToOne(mappedBy = "music", cascade = CascadeType.ALL)
    private DelightMusic delight;
    public void setTotalLikes(Double totalLikes) {
        this.totalLikes = totalLikes;
    }
}
