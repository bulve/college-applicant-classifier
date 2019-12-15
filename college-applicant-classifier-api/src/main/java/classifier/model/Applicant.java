package classifier.model;

import java.util.Collection;

/**
 * Defines base model for collage-applicant-classification system.
 * Applicant to be classified with {@link classifier.Classifier}
 *
 * @author Vasiliauskas
 */
public interface Applicant {

    /**
     * Represents applicant first name;
     */
    String getFirstName();

    /**
     * Sets applicant first name;
     */
    void setFirstName(String firstName);

    /**
     * Represents applicant last name;
     */
    String getLastName();

    /**
     * Sets applicant last name;
     */
    void setLastName(String lastName);

    /**
     * State where applicant is living;
     */
    String getState();

    /**
     * Sets state where applicant is living
     */
    void setState(String state);

    /**
     * Represents applicant age;
     */
    Integer getAge();

    /**
     * Sets applicant age;
     */
    void setAge(Integer age);

    /**
     * Represents applicant high school GPA score with scale;
     */
    GpaScore getGpaScore();

    /**
     * Sets applicant high school GPA score with scale;
     */
    void setGpaScore(GpaScore gpaScore);

    /**
     * Represents applicant high school STA score;
     */
    Integer getStaScore();

    /**
     * Sets applicant high school STA score;
     */
    void setStaScore(Integer staScore);

    /**
     * Represents applicant high school ACT score;
     */
    Integer getActScore();

    /**
     * Sets applicant high school ACT score;
     */
    void setActScore(Integer actScore);

    /**
     * Represents applicant felonies;
     */
    Collection<Felony> getFelonies();

    /**
     * Sets applicant felonies;
     */
    void setFelonies(Collection<Felony> felonies);
}
