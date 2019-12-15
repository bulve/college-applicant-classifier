package classifier.classification.rejection;

import classifier.model.*;
import classifier.model.factory.ClassifierModelFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FirstNameRejectionClassificationTest {

    private static final ClassifierModelFactory MODEL_FACTORY = ClassifierModelFactory.getInstance();

    private Classification firstNameUpperCased = new FirstNameUpperCasedRejectionClassification();
    private Classification firstNameNotCapitalized = new FirstNameNotCapitalizedRejectionClassification();

    @Test
    public void shouldClassifyAsNotQualifiedWithCapitalizedName(){
        ClassificationResult result = firstNameNotCapitalized.classify(validApplicant());
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.NOT_QUALIFIED));
    }

    @Test
    public void shouldClassifyAsNotQualifiedWithNameIsInLowerCases(){
        ClassificationResult result = firstNameUpperCased.classify(validApplicant());
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.NOT_QUALIFIED));
    }

    @Test
    public void shouldRejectWhenFirstNameIsNotCapitalized() {
        Applicant applicant = validApplicant();
        applicant.setFirstName("antony");
        ClassificationResult result = firstNameNotCapitalized.classify(applicant);
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.REJECTED));
        assertThat(result.getMessage(), is("Applicant first name is not capitalized."));
    }

    @Test
    public void shouldRejectWhenFirstNameIsInUpperCases() {
        Applicant applicant = validApplicant();
        applicant.setFirstName("ANTONY");
        ClassificationResult result = firstNameUpperCased.classify(applicant);
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.REJECTED));
        assertThat(result.getMessage(), is("Applicant first name contains upper case letter after the first one."));
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
