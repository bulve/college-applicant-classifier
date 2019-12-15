package classifier.classification.rejection;

import classifier.model.ClassificationResult;
import classifier.model.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

public class FelonyRejectionClassification implements Classification {

    private static final Integer MINIMUM_YEARS_WITHOUT_FELONIES = 5;

    @Override
    public ClassificationResult classify(Applicant applicant) {
        LocalDate localDate = LocalDate.now().minusYears(MINIMUM_YEARS_WITHOUT_FELONIES);
        Collection<Felony> felonies = applicant.getFelonies().stream()
                .filter(felony -> felony.getFelonyDate().isAfter(localDate))
                .collect(Collectors.toList());
        if(felonies.size() > 0) {
            return  new ClassificationResultImpl(
                    ClassificationAcceptance.REJECTED,
                    "Applicant had felonies in the past " + MINIMUM_YEARS_WITHOUT_FELONIES + " years");
        }
        return new ClassificationResultImpl(ClassificationAcceptance.NOT_QUALIFIED);
    }
}
