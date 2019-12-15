package classifier.model;

import classifier.ApplicantClassification;

import java.util.Collection;

public class ApplicantClassificationResultImpl implements ApplicantClassificationResult {

    private ApplicantClassification applicantClassification;

    private Collection<String> classificationMessages;

    public ApplicantClassificationResultImpl(ApplicantClassification applicantClassification, Collection<String> classificationMessages) {
        this.applicantClassification = applicantClassification;
        this.classificationMessages = classificationMessages;
    }

    @Override
    public ApplicantClassification getApplicantClassification() {
        return applicantClassification;
    }

    @Override
    public Collection<String> getClassificationMessages() {
        return classificationMessages;
    }
}
