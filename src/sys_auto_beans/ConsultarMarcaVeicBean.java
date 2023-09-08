package sys_auto_beans;

public class ConsultarMarcaVeicBean {
	private int id_veic;
	private String fabricante;
	private String veiculo;
	
	public int getId_veic() {
		return id_veic;
	}
	public void setId_veic(int id_veic) {
		this.id_veic = id_veic;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public String toString() {
	    return "ConsultarVeicBean{" +
	            "fabricante='" + fabricante + '\'' +
	            ", id_veic=" + id_veic +
	            '}';
	}


}
