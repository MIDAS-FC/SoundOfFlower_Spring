package midas.SoundOfFlower.repository.musiclike;

import midas.SoundOfFlower.entity.music.MusicLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicLikeRepository extends JpaRepository<MusicLike, Long> {

    Optional<MusicLike> findByUser_SocialIdAndMusic_Spotify(String socialId, String spotify);
    List<MusicLike> findByUser_SocialIdAndIsLikeTrue(String socialId);

}
