package classifier.classification.rejection;

import classifier.model.*;
import classifier.model.factory.ClassifierModelFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LastNameRejectionClassificationTest {

    private static final ClassifierModelFactory MODEL_FACTORY = ClassifierModelFactory.getInstance();

    private Classification lastNameUpperCased = new LastNameUpperCasedRejectionClassification();
    private Classification lastNameNotCapitalized = new LastNameNotCapitalizedRejectionClassification();

    @Test
    public void shouldClassifyAsNotQualifiedWithCapitalizedName(){
        ClassificationResult result = lastNameNotCapitalized.classify(validApplicant());
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.NOT_QUALIFIED));
    }

    @Test
    public void shouldClassifyAsNotQualifiedWithNameIsInLowerCases(){
        ClassificationResult result = lastNameUpperCased.classify(validApplicant());
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.NOT_QUALIFIED));
    }

    @Test
    public void shouldRejectWhenFirstNameIsNotCapitalized() {
        Applicant applicant = validApplicant();
        applicant.setLastName("antony");
        ClassificationResult result = lastNameNotCapitalized.classify(applicant);
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.REJECTED));
        assertThat(result.getMessage(), is("Applicant last name is not capitalized."));
    }

    @Test
    public void shouldRejectWhenFirstNameIsInUpperCases() {
        Applicant applicant = validApplicant();
        applicant.setLastName("ANTONY");
        ClassificationResult result = lastNameUpperCased.classify(applicant);
        assertThat(result.getClassificationAcceptance(), is(ClassificationAcceptance.REJECTED));
        assertThat(result.getMessage(), is("Applicant last name contains upper case letter after the first one."));
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
