package classifier;

/**
 *
 */
public interface ClassifierConfig {

    RejectionClassifier getRejectionClassifier();

    AcceptanceClassifier getAcceptanceClassifier();
}
