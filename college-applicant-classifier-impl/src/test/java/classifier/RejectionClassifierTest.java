package classifier;

import classifier.classification.provider.RejectionClassificationProvider;
import classifier.model.Applicant;
import classifier.model.ClassifierResult;
import classifier.model.Felony;
import classifier.model.GpaScore;
import classifier.model.factory.ClassifierModelFactory;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class RejectionClassifierTest {

    private static final ClassifierModelFactory MODEL_FACTORY = ClassifierModelFactory.getInstance();

    private RejectionClassificationProvider provider = new RejectionClassificationProvider();
    private RejectionClassifier classifier = new RejectionClassifier(provider.getClassifications());

    @Test
    public void shouldNotClassifyValidApplicant() {
        Applicant applicant = validApplicant();
        ClassifierResult result = classifier.classifyAsInstantRejected(applicant);
        assertThat(result.isClassified(), Matchers.is(false));
    }

    @Test
    public void shouldClassifyNotValidApplicant() {
        Applicant applicant = validApplicant();
        applicant.setAge(-2);
        ClassifierResult result = classifier.classifyAsInstantRejected(applicant);
        assertThat(result.isClassified(), Matchers.is(true));
        assertThat(result.getClassificationMessages(), hasSize(1));
        assertThat(
                result.getClassificationMessages().iterator().next(),
                is("Applicant provided age is negative.")
        );
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
