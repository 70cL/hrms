package io.kodloma.hrms.adapters.concrete;


import io.kodloma.hrms.adapters.Mernis.NNDKPSPublicSoap;
import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService<Candidates>{

    @Override
    public boolean ApiControl(Candidates candidates) {
        NNDKPSPublicSoap kpsPublic;

        try {
            kpsPublic = new NNDKPSPublicSoap();
            boolean durum = kpsPublic.TCKimlikNoDogrula(
                    Long.parseLong(candidates.getNationalidentity()),
                    candidates.getFirst_name().toUpperCase(),
                    candidates.getLast_name().toUpperCase(),
                    Integer.parseInt(candidates.getBirth_of_year()));
            return durum;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
