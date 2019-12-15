package classifier.model;

import java.time.LocalDate;

public class FelonyImpl implements Felony {

    private LocalDate felonyDate;

    @Override
    public LocalDate getFelonyDate() {
        return felonyDate;
    }

    @Override
    public void setFelonyDate(LocalDate felonyDate) {
        this.felonyDate = felonyDate;
    }
}
