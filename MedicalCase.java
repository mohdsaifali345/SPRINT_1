import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MedicalCase implements MedicalCase.Displayable {

    private int caseId;
    private String diagnosis;
    private String treatment;
    private LocalDate caseDate;

    // Interface inside MedicalCase
    public interface Displayable {
        void showDetails();
    }

    // Constructor with validation
    public MedicalCase(int caseId, String diagnosis, String treatment, LocalDate caseDate) {
        if (diagnosis == null || diagnosis.isEmpty()) {
            throw new IllegalArgumentException("Diagnosis cannot be null or empty.");
        }
        if (treatment == null || treatment.isEmpty()) {
            throw new IllegalArgumentException("Treatment cannot be null or empty.");
        }
        if (caseDate == null) {
            throw new IllegalArgumentException("Case date cannot be null.");
        }

        this.caseId = caseId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.caseDate = caseDate;
    }

    // Getters
    public int getCaseId() {
        return caseId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public LocalDate getCaseDate() {
        return caseDate;
    }

    // Implement showDetails() from Displayable
    @Override
    public void showDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        System.out.println("----- Medical Case Details -----");
        System.out.println("Case ID     : " + caseId);
        System.out.println("Diagnosis   : " + diagnosis);
        System.out.println("Treatment   : " + treatment);
        System.out.println("Case Date   : " + caseDate.format(formatter));
        System.out.println("--------------------------------");
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "MedicalCase{" +
                "caseId=" + caseId +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", caseDate=" + caseDate +
                '}';
    }
}
