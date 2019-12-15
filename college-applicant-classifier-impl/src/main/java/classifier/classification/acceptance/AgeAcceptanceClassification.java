package classifier.classification.acceptance;

import classifier.model.ClassificationResult;
import classifier.model.*;

public class AgeAcceptanceClassification implements Classification {

    private static final Integer MINIMUM_APPLICANT_AGE_IF_FROM_CALIFORNIA = 17;
    private static final Integer MAXIMUM_APPLICANT_AGE_IF_FROM_CALIFORNIA = 26;
    private static final Integer MINIMUM_APPLICANT_AGE_IF_ANY_STATE = 80;
    private static final String CALIFORNIA = "California";

    @Override
    public ClassificationResult classify(Applicant applicant) {
        Integer age = applicant.getAge();
        if(CALIFORNIA.equals(applicant.getState())
                && age != null
                && age >= MINIMUM_APPLICANT_AGE_IF_FROM_CALIFORNIA
                && age < MAXIMUM_APPLICANT_AGE_IF_FROM_CALIFORNIA) {
            return new ClassificationResultImpl(
                    ClassificationAcceptance.ACCEPTED,
                    "Applicant from " + CALIFORNIA + " is " + age + " years old.");
        } else if (age != null && age > MINIMUM_APPLICANT_AGE_IF_ANY_STATE){
            return new ClassificationResultImpl(
                    ClassificationAcceptance.ACCEPTED,
                    "Applicant from " + applicant.getState() + " is " + age + " years old.");
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
