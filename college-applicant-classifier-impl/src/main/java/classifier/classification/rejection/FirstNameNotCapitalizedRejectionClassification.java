package classifier.classification.rejection;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class FirstNameNotCapitalizedRejectionClassification implements Classification{

    @Override
    public ClassificationResult classify(Applicant applicant) {
        String firstName = applicant.getFirstName();
        if(firstName.length() > 0 && Character.isLowerCase(firstName.toCharArray()[0])){
            return new ClassificationResultImpl(
                    ClassificationAcceptance.REJECTED,
                    "Applicant first name is not capitalized.");
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
