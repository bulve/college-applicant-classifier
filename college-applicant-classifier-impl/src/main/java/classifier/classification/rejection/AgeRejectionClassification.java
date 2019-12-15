package classifier.classification.rejection;

import classifier.model.*;

public class AgeRejectionClassification implements Classification {

    @Override
    public ClassificationResult classify(Applicant applicant) {
        Integer age = applicant.getAge();
        if(age < 0) {
            return new ClassificationResultImpl(
                    ClassificationAcceptance.REJECTED,
                    "Applicant provided age is negative.");
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
