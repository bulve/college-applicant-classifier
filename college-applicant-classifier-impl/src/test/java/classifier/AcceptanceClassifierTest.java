package classifier;

import classifier.classification.provider.AcceptanceClassificationProvider;
import classifier.model.Applicant;
import classifier.model.ClassifierResult;
import classifier.model.Felony;
import classifier.model.GpaScore;
import classifier.model.factory.ClassifierModelFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

public class AcceptanceClassifierTest {

    private static final ClassifierModelFactory MODEL_FACTORY = ClassifierModelFactory.getInstance();

    private AcceptanceClassificationProvider provider = new AcceptanceClassificationProvider();
    private AcceptanceClassifier classifier = new AcceptanceClassifier(provider.getClassifications());

    @Test
    public void shouldClassifyValidApplicant() {
        Applicant applicant = validApplicant();
        ClassifierResult result = classifier.classifiesAsInstantAccepted(applicant);
        assertThat(result.isClassified(), is(true));
    }

    @Test
    public void shouldNotClassifyInValidApplicant() {
        Applicant applicant = validApplicant();
        applicant.setAge(16);
        ClassifierResult result = classifier.classifiesAsInstantAccepted(applicant);
        assertThat(result.isClassified(), is(false));
        assertThat(result.getClassificationMessages(), hasSize(2));
        List<String> messages = new ArrayList<>(result.getClassificationMessages());
        assertThat(messages, contains(
                "Applicant has GPA score higher than 90% of scale provided.",
                "Applicant has STA score greater than 1920"
        ));
    }

    private Applicant validApplicant() {
        Applicant applicant = MODEL_FACTORY.createApplicant();
        applicant.setFirstName("Antonio");
        applicant.setLastName("Padre");
        applicant.setState("California");
        applicant.setAge(17);
        GpaScore gpaScore = MODEL_FACTORY.createGpaScore();
        gpaScore.setGpaScale(5.0);
        gpaScore.setGpaScore(4.6);
        applicant.setGpaScore(gpaScore);
        applicant.setActScore(27);
        applicant.setStaScore(1921  );
        Felony felony1 = MODEL_FACTORY.createFelony();
        felony1.setFelonyDate(LocalDate.MIN);
        Felony felony2 = MODEL_FACTORY.createFelony();
        felony2.setFelonyDate(LocalDate.MIN.plusYears(10));
        applicant.setFelonies(Arrays.asList(felony1, felony2));
        return applicant;
    }
}
