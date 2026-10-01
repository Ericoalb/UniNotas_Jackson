package Unicotas;
import java.util.ArrayList;

public class FaculdadeRepository {
    private ArrayList<FaculdadeEntity> faculdades;

    public FaculdadeRepository()
    {
        this.faculdades = new ArrayList<FaculdadeEntity>();
    }
    public void salvarFaculdade(FaculdadeEntity faculdade)
    {
        this.faculdades.add(faculdade);
    }
    public ArrayList<FaculdadeEntity> buscarFaculdades()
    {
        return this.faculdades;
    }
    public FaculdadeEntity buscarFaculdadeID(int idFaculdade)
    {
        return this.faculdades.get(idFaculdade);
    }
    public FaculdadeEntity atualizarFaculdade(FaculdadeEntity faculdade, String name, String cnpj)
    {
        int index = this.faculdades.indexOf(faculdade);
        FaculdadeEntity f = this.faculdades.get(index);
        f.setName(name);
        f.setCnpj(cnpj);
        return f;
    }
    public void removerFaculdade(FaculdadeEntity faculdade)
    {
        this.faculdades.remove(faculdade);
    }
}