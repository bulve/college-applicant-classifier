package classifier.classification.rejection;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class FirstNameUpperCasedRejectionClassification implements Classification{

    @Override
    public ClassificationResult classify(Applicant applicant) {
        String firstName = applicant.getFirstName();
        if(firstName != null && firstName.length() > 0) {
            char[] firstNameChars = firstName.toCharArray();
            for (int i = 1; i < firstNameChars.length; i++) {
                boolean isLowerCase = Character.isLowerCase(firstNameChars[i]);
                if (!isLowerCase) {
                    return new ClassificationResultImpl(
                            ClassificationAcceptance.REJECTED,
                            "Applicant first name contains upper case letter after the first one.");
                }
            }
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
