package interfete;

import java.time.LocalDate;

public interface Imprumutabil {
    void imprumuta(LocalDate dataImprumut) throws Exception;
    void returneaza(LocalDate dataRetur) throws Exception;
    double calculPenalizare(LocalDate dataRetur);

}
