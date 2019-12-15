package classifier;

import classifier.model.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RejectionClassifier {

    private Collection<Classification> rejectionClassification;

    public RejectionClassifier(Collection<Classification> rejectionClassification) {
        this.rejectionClassification = rejectionClassification;
    }

    ClassifierResult classifyAsInstantRejected(Applicant applicant) {
        List<String> rejectionMessages = rejectionClassification.stream()
                .map(classification -> classification.classify(applicant))
                .filter(result -> result.getClassificationAcceptance().equals(ClassificationAcceptance.REJECTED))
                .map(ClassificationResult::getMessage)
                .collect(Collectors.toList());
        return new ClassifierResultImpl(rejectionMessages.size() > 0, rejectionMessages);
    }
}
