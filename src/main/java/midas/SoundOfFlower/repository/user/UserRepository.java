package midas.SoundOfFlower.repository.user;

import midas.SoundOfFlower.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, DeleteUser {

    boolean existsBySocialId(String socialId);

    boolean existsByEmailAndRole(String email, String role);

    Optional<User> findByNickName(String nickname);

    Optional<User> findBySocialTypeAndEmailAndRole(String socialType,String email,String role);

    boolean existsByEmailAndSocialTypeAndRole(String email, String socialType, String role);
    Optional<User> findBySocialId(String socialId);

    boolean existsByNickName(String nickName);
}
