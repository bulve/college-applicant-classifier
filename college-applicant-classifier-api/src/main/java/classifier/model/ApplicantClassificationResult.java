package classifier.model;

import classifier.ApplicantClassification;

import java.util.Collection;

/**
 * Represents {@link Applicant} clarification result yelled from {@link classifier.Classifier}
 *
 * @author Vasiliauskas
 */
public interface ApplicantClassificationResult {

    /**
     * @return applicant classification marker
     *
     * @see ApplicantClassification
     */
    ApplicantClassification getApplicantClassification();

    /**
     * @return applicant classification messages
     */
    Collection<String> getClassificationMessages();
}
