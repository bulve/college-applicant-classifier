package classifier.model;

public class GpaScoreImpl implements GpaScore {

    private Double gpaScore;
    private Double gpaScale;

    @Override
    public Double getGpaScore() {
        return gpaScore;
    }

    @Override
    public void setGpaScore(Double gpaScore) {
        this.gpaScore = gpaScore;
    }

    @Override
    public Double getGpaScale() {
        return gpaScale;
    }

    @Override
    public void setGpaScale(Double gpaScale) {
        this.gpaScale = gpaScale;
    }
}
