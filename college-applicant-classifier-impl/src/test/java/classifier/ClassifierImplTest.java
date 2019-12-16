package classifier;

import classifier.model.Applicant;
import classifier.model.ApplicantClassificationResult;
import classifier.model.Felony;
import classifier.model.GpaScore;
import classifier.model.factory.ClassifierModelFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ClassifierImplTest {

    private static final ClassifierModelFactory MODEL_FACTORY = ClassifierModelFactory.getInstance();

    private final Classifier classifier = ClassifierBuilder.newInstance().buildClassifier();

    @Test
    public void shouldClassifyApplicantAsInstantRejected() {
        Applicant applicant = validApplicant();
        applicant.setFirstName("ANTONY");
        applicant.setLastName("FREDERIC");
        ApplicantClassificationResult result = classifier.classify(applicant);
        assertThat(result.getApplicantClassification(), is(ApplicantClassification.INSTANT_REJECT));
        List<String> messages = new ArrayList<>(result.getClassificationMessages());
        assertThat(messages, hasSize(2));
        assertThat(
                messages,
                containsInAnyOrder(
                        "Applicant first name contains upper case letter after the first one.",
                        "Applicant last name contains upper case letter after the first one.")
        );
    }

    @Test
    public void shouldClassifyApplicantAsInstanceAccepted(){
        Applicant applicant = validApplicant();
        ApplicantClassificationResult result = classifier.classify(applicant);
        assertThat(result.getApplicantClassification(), is(ApplicantClassification.INSTANT_ACCEPT));
        assertThat(result.getClassificationMessages(), hasSize(3));
    }

    @Test
    public void shouldRejectWhenGpaIsTooLow(){
        Applicant applicant = validApplicant();
        applicant.getGpaScore().setGpaScore(1.0);
        ApplicantClassificationResult result = classifier.classify(applicant);
        assertThat(result.getApplicantClassification(), is(ApplicantClassification.INSTANT_REJECT));
        assertThat(result.getClassificationMessages(), hasSize(1));
        assertThat(result.getClassificationMessages(), contains("Applicant has GPA below 70% of scale provided"));
    }

    @Test
    public void shouldPlaceForFurtherReviewWhenApplicantIsTooYoung(){
        Applicant applicant = validApplicant();
        applicant.setAge(16);
        ApplicantClassificationResult result = classifier.classify(applicant);
        assertThat(result.getApplicantClassification(), is(ApplicantClassification.FURTHER_REVIEW));
        assertThat(result.getClassificationMessages(), hasSize(2));
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
