package Unicotas;
import java.util.ArrayList;
import java.util.Scanner;

public class FaculdadeService {
    private FaculdadeRepository faculdadeRepository = new FaculdadeRepository();

    public FaculdadeService()
    {}
    public void cadastrarFaculdadede(FaculdadeEntity faculdade)
    {
        this.faculdadeRepository.salvarFaculdade(faculdade);
    }
    public ArrayList<FaculdadeEntity> listarFaculdade()
    {
        ArrayList<FaculdadeEntity> faculdades = this.faculdadeRepository.buscarFaculdades();
        return faculdades;
    }
    public FaculdadeEntity buscarFaculdadeId(int id)
    {
        return this.faculdadeRepository.buscarFaculdadeID(id);
    }
    public String atualizarFaculdade(FaculdadeEntity faculdade, String name, String cnpj)
    {
        String resul = "Faculdade [" + faculdade.getName() + "]" + " com Cnpj: [" + faculdade.getCnpj() +"]";
        faculdade.setName(name);
        faculdade.setCnpj(cnpj);
        resul += " \natualizado para [" + faculdade.getName() + ", " + faculdade.getCnpj() + "]";
        return resul;
    }
    public void removerFaculdade(FaculdadeEntity faculdade)
    {
        this.faculdadeRepository.removerFaculdade(faculdade);
    }
}