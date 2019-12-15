package classifier;

/**
 * {@link classifier.model.Applicant) classification markers.
 *
 * @author Vasiliauskas
 */
public enum ApplicantClassification {
    /**
     * Classifies {@link classifier.model.Applicant} as instantly rejected.
     */
    INSTANT_REJECT,
    /**
     * Classifies {@link classifier.model.Applicant} as instantly accepted.
     */
    INSTANT_ACCEPT,
    /**
     * Classifies {@link classifier.model.Applicant} as for further review.
     */
    FURTHER_REVIEW
}
