package classifier.classification.acceptance;

import classifier.model.*;
import classifier.model.factory.ClassifierModelFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GpaScoreAcceptanceClassificationTest {

    private static final ClassifierModelFactory MODEL_FACTORY = ClassifierModelFactory.getInstance();

    private Classification classification = new GpaScoreAcceptanceClassification();

    @Test
    public void shouldClassifyAsAccepted(){
        ClassificationResult result = classification.classify(validApplicant());
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.ACCEPTED));
        assertThat(result.getMessage(), is("Applicant has GPA score higher than 90% of scale provided."));
    }

    @Test
    public void shouldMarkAsNotQualifiedWhenGpaIsTooLow() {
        Applicant applicant = validApplicant();
        GpaScore gpaScore = applicant.getGpaScore();
        gpaScore.setGpaScore(1.0);
        gpaScore.setGpaScale(5.0);
        ClassificationResult result = classification.classify(applicant);
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.NOT_QUALIFIED));
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
