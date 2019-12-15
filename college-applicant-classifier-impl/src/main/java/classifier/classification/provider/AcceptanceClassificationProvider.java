package classifier.classification.provider;

import classifier.classification.acceptance.AgeAcceptanceClassification;
import classifier.classification.acceptance.GpaScoreAcceptanceClassification;
import classifier.classification.acceptance.StaActScroeAcceptanceClassification;
import classifier.model.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Provides acceptance {@link Classification} for classifying {@link Applicant} with {@link classifier.Classifier}.
 *
 * @author Vasiliauskas
 */
public class AcceptanceClassificationProvider implements ClassificationProvider {

    @Override
    public Collection<Classification> getClassifications() {
        return Arrays.asList(
                new AgeAcceptanceClassification(),
                new GpaScoreAcceptanceClassification(),
                new StaActScroeAcceptanceClassification()
        );
    }

    @Override
    public ClassificationProviderType getClassificationProviderType() {
        return ClassificationProviderType.ACCEPTANCE;
    }
}
