package midas.SoundOfFlower.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryInfoResponse {

    private Long diaryId;

    private LocalDate date;

    private String title;
    private String comment;

    private String flower;

    private List<String> imgUrl;

    private Double angry;
    private Double sad;
    private Double delight;
    private Double calm;
    private Double depressed;
    private Double anxiety;
    private Double love;

    private String spotify;

    private boolean like;
    private boolean haveSeen;

    public void updateFlower(String flower) {
        this.flower = flower;
    }

    public void updateImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void updateEmotion(Double angry, Double sad, Double delight, Double calm, Double depressed, Double anxiety,Double love) {
        this.angry = angry;
        this.sad = sad;
        this.delight = delight;
        this.calm = calm;
        this.depressed = depressed;
        this.anxiety = anxiety;
        this.love = love;
    }

    public void updateDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }

    public void updateMusic(String spotify) {
        this.spotify = spotify;
    }

    public void updateLike(boolean like) {
        this.like = like;
    }
    public void updateHaveSeen(boolean isLike) {this.haveSeen = haveSeen;}

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateComment(String comment) {
        this.comment = comment;
    }

    public void updateDate(LocalDate localDate) {
        this.date = localDate;
    }
}
