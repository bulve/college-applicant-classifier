package classifier.model;

/**
 * {@link Applicant} classification identified by {@link Classification}.
 *
 * @author Vasiliauskas
 */
public enum ClassificationAcceptance {
    /**
     * Applicant classified as accepted for specific {@link Classification}.
     */
    ACCEPTED,

    /**
     * Applicant classified as rejected for specific {@link Classification}.
     */
    REJECTED,

    /**
     * Applicant classified as {@link this#NOT_QUALIFIED}, when {@link Classification} is not applied on applicant.
     * Used when applicant cannot be identified as {@link this#ACCEPTED} or {@link this#REJECTED}.
     */
    NOT_QUALIFIED
}
