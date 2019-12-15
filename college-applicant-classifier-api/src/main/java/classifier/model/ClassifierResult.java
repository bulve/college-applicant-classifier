package classifier.model;

import java.util.Collection;

/**
 * {@link classifier.Classifier} result that classifies {@link Applicant}
 */
public interface ClassifierResult {

    boolean isClassified();

    Collection<String> getClassificationMessages();

}
