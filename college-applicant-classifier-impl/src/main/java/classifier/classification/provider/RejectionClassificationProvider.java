package classifier.classification.provider;

import classifier.classification.rejection.*;
import classifier.model.Applicant;
import classifier.model.Classification;
import classifier.model.ClassificationProvider;
import classifier.model.ClassificationProviderType;

import java.util.Arrays;
import java.util.Collection;

/**
 * Provides rejection {@link Classification} for classifying {@link Applicant} with {@link classifier.Classifier}.
 *
 * @author Vasiliauskas
 */
public class RejectionClassificationProvider implements ClassificationProvider {

    @Override
    public Collection<Classification> getClassifications() {
        return Arrays.asList(
                new AgeRejectionClassification(),
                new FelonyRejectionClassification(),
                new FirstNameNotCapitalizedRejectionClassification(),
                new FirstNameUpperCasedRejectionClassification(),
                new GpaScoreRejectionClassification(),
                new LastNameNotCapitalizedRejectionClassification(),
                new LastNameUpperCasedRejectionClassification()
        );
    }

    @Override
    public ClassificationProviderType getClassificationProviderType() {
        return ClassificationProviderType.REJECTION;
    }
}
