package classifier.model;


public class ClassificationResultImpl implements ClassificationResult {

    private ClassificationAcceptance classificationAcceptance;

    private String message;

    public ClassificationResultImpl(ClassificationAcceptance classificationAcceptance, String message) {
        this.classificationAcceptance = classificationAcceptance;
        this.message = message;
    }

    public ClassificationResultImpl(ClassificationAcceptance classificationAcceptance) {
        this.classificationAcceptance = classificationAcceptance;
        this.message = "";
    }

    @Override
    public ClassificationAcceptance getClassificationAcceptance() {
        return classificationAcceptance;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
