package classifier;

import classifier.model.Applicant;
import classifier.model.ApplicantClassificationResult;
import classifier.model.ApplicantClassificationResultImpl;
import classifier.model.ClassifierResult;

/**
 * Classifier for {@link Applicant}
 * Will classify applicant with provided classifiers
 * {@link AcceptanceClassifier} and {@link RejectionClassifier} in {@link ClassifierConfig}
 *
 * If applicant classified as instance rejected will have result with {@link ApplicantClassification#INSTANT_REJECT}
 * If classified as instance accepted will have result with {@link ApplicantClassification#INSTANT_ACCEPT}
 * If none of above result will contain {@link ApplicantClassification#FURTHER_REVIEW}
 *
 * @author Vasiliauskas
 *
 */
public class ClassifierImpl implements Classifier {

    private AcceptanceClassifier acceptanceClassifier;

    private RejectionClassifier rejectionClassifier;

    public ClassifierImpl(ClassifierConfig classifierConfig) {
        this.acceptanceClassifier = classifierConfig.getAcceptanceClassifier();
        this.rejectionClassifier = classifierConfig.getRejectionClassifier();
    }

    public ApplicantClassificationResult classify(Applicant applicant) {
        ClassifierResult classifiedAsInstantAccepted = acceptanceClassifier.classifiesAsInstantAccepted(applicant);
        ClassifierResult classifiedAsInstantRejected = rejectionClassifier.classifyAsInstantRejected(applicant);

        if(classifiedAsInstantRejected.isClassified()) {
            return new ApplicantClassificationResultImpl(
                    ApplicantClassification.INSTANT_REJECT,
                    classifiedAsInstantRejected.getClassificationMessages()
            );
        } else if (classifiedAsInstantAccepted.isClassified()) {
            return new ApplicantClassificationResultImpl(
                    ApplicantClassification.INSTANT_ACCEPT,
                    classifiedAsInstantAccepted.getClassificationMessages()
            );
        } else {
            return new ApplicantClassificationResultImpl(
                    ApplicantClassification.FURTHER_REVIEW,
                    classifiedAsInstantAccepted.getClassificationMessages()
            );
        }
    }
}
