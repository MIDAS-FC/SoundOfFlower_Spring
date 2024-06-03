package midas.SoundOfFlower.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import midas.SoundOfFlower.entity.diary.Diary;
import midas.SoundOfFlower.entity.music.MusicLike;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
@Builder
@Table(name = "USER")
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String socialId;

    private String email; // 이메일

    @Column(length = 2555)
    private String password; // 비밀번호

    @Column(length = 30)
    private String nickName; // 닉네임

    @Column(length = 2048)
    private String imageUrl; // 프로필 이미지

    @Column(length = 5)
    private String role;

    @Column(length = 15)
    private String socialType; // KAKAO, NAVER, GOOGLE

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diary> diary = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MusicLike> musicLikes = new ArrayList<>();

    public void updateNickname(String updateNickname) {
        this.nickName = updateNickname;
    }
    public void updateProfile(String updateProfile) { this.imageUrl = updateProfile; }

    public void updatePassword(String updatePassword) {
        this.password = updatePassword;
    }

    public void updateRole(String role) {this.role = role;}

    public void updateAll(String email, String pw,String url,String socialType) {
        this.email = email;
        this.password = pw;
        this.imageUrl = url;
        this.socialType = socialType;
    }

    public Diary findDiaryByDate(Long year, Long month, Long day) {
        LocalDate targetDate = LocalDate.of(year.intValue(), month.intValue(), day.intValue());
        return diary.stream()
                .filter(d -> d.getDate().isEqual(targetDate))
                .findFirst()
                .orElse(null);
    }
}
