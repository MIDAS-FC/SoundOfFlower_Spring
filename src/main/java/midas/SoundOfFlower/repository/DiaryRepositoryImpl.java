package midas.SoundOfFlower.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import midas.SoundOfFlower.dto.response.DiaryInfoResponse;

import java.util.List;

import static midas.SoundOfFlower.entity.QDiary.diary;
import static org.springframework.util.StringUtils.isEmpty;

public class DiaryRepositoryImpl implements SearchDiary {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public DiaryRepositoryImpl(EntityManager em, JPAQueryFactory queryFactory) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<DiaryInfoResponse> getDiaryInfo(Long year, Long month, String socialId) {
        return queryFactory
                .select(Projections.fields(DiaryInfoResponse.class,
                        diary.comment,
                        diary.flower,
                        diary.angry,
                        diary.sad,
                        diary.delight,
                        diary.calm,
                        diary.embarrased,
                        diary.anxiety,
                        diary.music.musicId,
                        diary.music.title,
                        diary.music.singer,
                        diary.music.likes
                ))
                .from(diary)
                .where(yearEq(year), monthEq(month), socialIdEq(socialId))
                .fetch();
    }

    private BooleanExpression yearEq(Long year) {

        if (year == null) {
            return null;
        }

        return diary.date.year().eq(year.intValue());
    }

    private BooleanExpression monthEq(Long month) {

        if (month == null) {
            return null;
        }

        return diary.date.month().eq(month.intValue());
    }

    private BooleanExpression socialIdEq(String socialId) {
        return isEmpty(socialId) ? null : diary.user.socialId.eq(socialId);
    }
}
