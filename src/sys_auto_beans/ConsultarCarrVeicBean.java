package sys_auto_beans;

public class ConsultarCarrVeicBean {
	private int id_veic;
	private String fabricante;
	private String modelo;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public String toString() {
		return "ConsultarCarrVeicBean [id_veic=" + id_veic + ", fabricante=" + fabricante + ", modelo=" + modelo
				+ ", veiculo=" + veiculo + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + id_veic;
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultarCarrVeicBean other = (ConsultarCarrVeicBean) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (id_veic != other.id_veic)
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}
	

}
