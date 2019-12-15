package classifier.model;

import java.time.LocalDate;

/**
 * {@link Applicant} felony
 *
 * @author Vasiliauskas
 */
public interface Felony {

    LocalDate getFelonyDate();

    void setFelonyDate(LocalDate felonyDate);
}
