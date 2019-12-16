package classifier;

import classifier.model.Classification;
import classifier.model.ClassificationProvider;
import classifier.model.ClassificationProviderType;

import java.util.Collection;
import java.util.stream.Collectors;

public class ClassifierConfig {

    private RejectionClassifier rejectionClassifier;
    private AcceptanceClassifier acceptanceClassifier;

    public ClassifierConfig(Collection<ClassificationProvider> classificationProviders) {
        this.rejectionClassifier = new RejectionClassifier(
                getClassificationByProviderType(classificationProviders, ClassificationProviderType.REJECTION)
        );
        this.acceptanceClassifier = new AcceptanceClassifier(
                getClassificationByProviderType(classificationProviders, ClassificationProviderType.ACCEPTANCE)
        );
    }

    public RejectionClassifier getRejectionClassifier() {
        return rejectionClassifier;
    }

    public AcceptanceClassifier getAcceptanceClassifier() {
        return acceptanceClassifier;
    }

    private Collection<Classification> getClassificationByProviderType(Collection<ClassificationProvider> providers,
                                                                       ClassificationProviderType providerType) {
        return providers.stream()
                .filter(provider -> provider.getClassificationProviderType().equals(providerType))
                .flatMap(provide -> provide.getClassifications().stream())
                .collect(Collectors.toList());
    }
}
