package classifier.classification.acceptance;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class StaActScroeAcceptanceClassification implements Classification {

    private static final Integer MINIMUM_ACT_SCORE = 27;
    private static final Integer MINIMUM_STA_SCORE = 1920;

    @Override
    public ClassificationResult classify(Applicant applicant) {
        Integer staScore = applicant.getStaScore();
        Integer actScore = applicant.getActScore();
        if(actScore != null && actScore > MINIMUM_ACT_SCORE ){
            return new ClassificationResultImpl(
                    ClassificationAcceptance.ACCEPTED,
                    "Applicant has ACT score greater than " + MINIMUM_ACT_SCORE);
        } else if (staScore != null && staScore > MINIMUM_STA_SCORE) {
            return new ClassificationResultImpl(
                    ClassificationAcceptance.ACCEPTED,
                    "Applicant has STA score greater than " + MINIMUM_STA_SCORE);
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
