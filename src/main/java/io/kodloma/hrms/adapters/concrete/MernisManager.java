package io.kodloma.hrms.adapters.concrete;


import io.kodloma.hrms.adapters.Mernis.VAJKPSPublicSoap;
import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService<Candidates>{

    @Override
    public boolean ApiControl(Candidates candidates) {
        VAJKPSPublicSoap kpsPublic;
        try {
            kpsPublic = new VAJKPSPublicSoap();
            boolean durum = kpsPublic.TCKimlikNoDogrula(
                    Long.parseLong(candidates.getNationalidentity()),
                    candidates.getFirst_name().toUpperCase(),
                    candidates.getLast_name().toUpperCase(),
                    Integer.parseInt(candidates.getDate_of_birth()));
            return durum;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
