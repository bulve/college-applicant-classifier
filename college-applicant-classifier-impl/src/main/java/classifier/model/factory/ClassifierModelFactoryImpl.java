package classifier.model.factory;

import classifier.model.*;

public class ClassifierModelFactoryImpl implements ClassifierModelFactory {

    @Override
    public Applicant createApplicant() {
        return new ApplicantImpl();
    }

    @Override
    public GpaScore createGpaScore() {
        return new GpaScoreImpl();
    }

    @Override
    public Felony createFelony() {
        return new FelonyImpl();
    }
}
