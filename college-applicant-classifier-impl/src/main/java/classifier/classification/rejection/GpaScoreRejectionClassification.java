package classifier.classification.rejection;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class GpaScoreRejectionClassification implements Classification {

    @Override
    public ClassificationResult classify(Applicant applicant) {
        GpaScore gpaScore = applicant.getGpaScore();
        double gpaResult = gpaScore.getGpaScore() * 100 / gpaScore.getGpaScale();
        if (gpaResult < 70) {
            String message = "Applicant has GPA below 70% of scale provided";
            return new ClassificationResultImpl(ClassificationAcceptance.REJECTED, message);
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
