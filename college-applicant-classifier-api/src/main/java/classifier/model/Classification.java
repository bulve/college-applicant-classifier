package classifier.model;

/**
 * Applicant classification property/requirement.
 * Must be supplied/collected by {@link ClassificationProvider}.
 * For use by {@link classifier.Classifier} to identify {@link Applicant} classification.
 *
 * @author Vasiliauskas
 */
@FunctionalInterface
public interface Classification {

    /**
     * @param applicant to classify
     * @return {@link ClassificationResult}
     */
    ClassificationResult classify(Applicant applicant);
}
