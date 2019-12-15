package classifier.classification.acceptance;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class GpaScoreAcceptanceClassification implements Classification {

    @Override
    public ClassificationResult classify(Applicant applicant) {
        GpaScore gpaScore = applicant.getGpaScore();
        double gpaResult = gpaScore.getGpaScore() * 100 / gpaScore.getGpaScale();
        if(gpaResult >= 90){
            return new ClassificationResultImpl(
                    ClassificationAcceptance.ACCEPTED,
                    "Applicant has GPA score higher than 90% of scale provided.");
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
