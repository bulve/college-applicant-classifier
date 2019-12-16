package classifier;

import classifier.classification.provider.ClassificationProvidersProvider;

public class ClassifierBuilder {

    private ClassifierConfig classifierConfig;

    private ClassifierBuilder() {
    }

    public static ClassifierBuilder newInstance() {
        return new ClassifierBuilder();
    }

    public ClassifierBuilder setClassifierConfig(ClassifierConfig classifierConfig) {
        this.classifierConfig = classifierConfig;
        return this;
    }

    public Classifier buildClassifier(){
        if(classifierConfig == null){
            classifierConfig = new ClassifierConfig(ClassificationProvidersProvider.getClassificationProviders());
        }
        Classifier classifier = new ClassifierImpl(classifierConfig);
        return classifier;
    }
}
