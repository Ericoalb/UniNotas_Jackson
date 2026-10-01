package Unicotas;

public class FaculdadeEntity {
    private String name;
    private String cnpj;
    private int id;

    public FaculdadeEntity()
    {

    }


    public FaculdadeEntity(String name, String cnpj, int id)
    {
        this.name = name;
        this.cnpj = cnpj;
        this.id = id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getCnpj()
    {
        return this.cnpj;
    }
    public int getId()
    {
        return this.id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }
    public void setID(int id)
    {
        this.id = id;
    }
}