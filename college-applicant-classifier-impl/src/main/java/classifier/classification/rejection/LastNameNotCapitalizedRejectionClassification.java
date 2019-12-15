package classifier.classification.rejection;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class LastNameNotCapitalizedRejectionClassification implements Classification{

    @Override
    public ClassificationResult classify(Applicant applicant) {
        String lastName = applicant.getLastName();
        if(lastName.length() > 0 && Character.isLowerCase(lastName.toCharArray()[0])){
            return new ClassificationResultImpl(
                    ClassificationAcceptance.REJECTED,
                    "Applicant last name is not capitalized.");
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
