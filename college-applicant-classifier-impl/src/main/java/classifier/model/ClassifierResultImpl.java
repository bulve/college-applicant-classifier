package classifier.model;

import java.util.Collection;

public class ClassifierResultImpl implements ClassifierResult{
    private boolean classified;
    private Collection<String> classificationMessages;

    public ClassifierResultImpl(boolean classified, Collection<String> classificationMessages) {
        this.classified = classified;
        this.classificationMessages = classificationMessages;
    }

    @Override
    public boolean isClassified() {
        return classified;
    }

    @Override
    public Collection<String> getClassificationMessages() {
        return classificationMessages;
    }
}
