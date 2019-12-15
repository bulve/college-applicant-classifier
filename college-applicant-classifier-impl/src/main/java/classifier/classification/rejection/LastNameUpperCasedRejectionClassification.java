package classifier.classification.rejection;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class LastNameUpperCasedRejectionClassification implements Classification{

    @Override
    public ClassificationResult classify(Applicant applicant) {
        String lastName = applicant.getLastName();
        if(lastName != null && lastName.length() > 0) {
            char[] lastNameChars = lastName.toCharArray();
            for (int i = 1; i < lastNameChars.length; i++) {
                boolean isLowerCase = Character.isLowerCase(lastNameChars[i]);
                if (!isLowerCase) {
                    return new ClassificationResultImpl(
                            ClassificationAcceptance.REJECTED,
                            "Applicant last name contains upper case letter after the first one.");
                }
            }
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
