package classifier.model;

import java.util.Collection;

/**
 * Provides used to supply {@link Classification} by {@link ClassificationProviderType} to {@link classifier.Classifier}
 *
 * @author Vasiliauskas
 */
public interface ClassificationProvider {

    /**
     * @return Classifications to classify {@link Applicant}
     */
    Collection<Classification> getClassifications();

    /**
     * @return Identifies {@link Classification} type to classify {@link Applicant}
     */
    ClassificationProviderType getClassificationProviderType();

}
