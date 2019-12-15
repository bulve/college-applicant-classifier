package classifier;

import classifier.model.Applicant;
import classifier.model.ApplicantClassificationResult;

/**
 * Classifier API for classifying {@link Applicant}
 *
 * @author Vasiliauskas
 */
public interface Classifier {

    /**
     * Classifies {@link Applicant} as
     * {@link ApplicantClassification#INSTANT_REJECT} or
     * {@link ApplicantClassification#INSTANT_ACCEPT} or
     * {@link ApplicantClassification#FURTHER_REVIEW}
     * with {@link String}reason messages
     *
     * @param applicant to be classified
     * @return
     */
    ApplicantClassificationResult classify(Applicant applicant);

}
