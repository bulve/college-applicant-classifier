package classifier.model;

import java.util.Collection;

public class ApplicantImpl implements Applicant {

    private String firstName;
    private String lastName;
    private String state;
    private Integer age;
    private GpaScore gpaScore;
    private Integer staScore;
    private Integer actScore;
    private Collection<Felony> felonies;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public GpaScore getGpaScore() {
        return gpaScore;
    }

    @Override
    public void setGpaScore(GpaScore gpaScore) {
        this.gpaScore = gpaScore;
    }

    @Override
    public Integer getStaScore() {
        return staScore;
    }

    @Override
    public void setStaScore(Integer staScore) {
        this.staScore = staScore;
    }

    @Override
    public Integer getActScore() {
        return actScore;
    }

    @Override
    public void setActScore(Integer actScore) {
        this.actScore = actScore;
    }

    @Override
    public Collection<Felony> getFelonies() {
        return felonies;
    }

    @Override
    public void setFelonies(Collection<Felony> felonies) {
        this.felonies = felonies;
    }
}
