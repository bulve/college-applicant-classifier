package classifier;

import classifier.model.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AcceptanceClassifier {

    private Collection<Classification> acceptanceClassifications;

    public AcceptanceClassifier(Collection<Classification> acceptanceClassifications) {
        this.acceptanceClassifications = acceptanceClassifications;
    }

    ClassifierResult classifiesAsInstantAccepted(Applicant applicant) {
        List<String> acceptanceMessages = acceptanceClassifications.stream()
                .map(classification -> classification.classify(applicant))
                .filter(result -> result.getClassificationAcceptance().equals(ClassificationAcceptance.ACCEPTED))
                .map(ClassificationResult::getMessage)
                .collect(Collectors.toList());
        return new ClassifierResultImpl(
                acceptanceMessages.size() == acceptanceClassifications.size(),
                acceptanceMessages);
    }
}
