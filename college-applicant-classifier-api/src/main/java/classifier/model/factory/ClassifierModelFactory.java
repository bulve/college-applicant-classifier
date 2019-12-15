package classifier.model.factory;

import classifier.model.Applicant;
import classifier.model.Felony;
import classifier.model.GpaScore;

/**
 * Factory to abstract classifier model creation with implementation provided as service
 *
 * @author Vasiliauskas
 */
public interface ClassifierModelFactory {

    static ClassifierModelFactory getInstance() {
        return ClassifierModelFactoryProvider.getInstance();
    }

    Applicant createApplicant();

    GpaScore createGpaScore();

    Felony createFelony();
}
