package sys_auto_beans;

public class AnuncioBean {
	private int id_anunc_veic;
	private String anunc_fabricante;
	private String anunc_modelo;
	private int anunc_anoVeic;
	private String anunc_veiculo;
	private String ipva_StatusVeic;
	private String licenca_StatusVeic;
	byte[] foto_Veic;
	private String km_Veic;
	private String preco_veiculo;
	private String combst_veiculo;
	private String descr_veic;
	
	public int getId_anunc_veic() {
		return id_anunc_veic;
	}
	public void setId_anunc_veic(int id_anunc_veic) {
		this.id_anunc_veic = id_anunc_veic;
	}
	public String getAnunc_fabricante() {
		return anunc_fabricante;
	}
	public void setAnunc_fabricante(String anunc_fabricante) {
		this.anunc_fabricante = anunc_fabricante;
	}
	public String getAnunc_modelo() {
		return anunc_modelo;
	}
	public void setAnunc_modelo(String anunc_modelo) {
		this.anunc_modelo = anunc_modelo;
	}
	public int getAnunc_anoVeic() {
		return anunc_anoVeic;
	}
	public void setAnunc_anoVeic(int anunc_anoVeic) {
		this.anunc_anoVeic = anunc_anoVeic;
	}
	public String getAnunc_veiculo() {
		return anunc_veiculo;
	}
	public void setAnunc_veiculo(String anunc_veiculo) {
		this.anunc_veiculo = anunc_veiculo;
	}
	public String getIpva_StatusVeic() {
		return ipva_StatusVeic;
	}
	public void setIpva_StatusVeic(String ipva_StatusVeic) {
		this.ipva_StatusVeic = ipva_StatusVeic;
	}
	public String getLicenca_StatusVeic() {
		return licenca_StatusVeic;
	}
	public void setLicenca_StatusVeic(String licenca_StatusVeic) {
		this.licenca_StatusVeic = licenca_StatusVeic;
	}
	public byte[] getFoto_Veic() {
		return foto_Veic;
	}
	public void setFoto_Veic(byte[] foto_Veic) {
		this.foto_Veic = foto_Veic;
	}
	public String getKm_Veic() {
		return km_Veic;
	}
	public void setKm_Veic(String km_Veic) {
		this.km_Veic = km_Veic;
	}
	public String getPreco_veiculo() {
		return preco_veiculo;
	}
	public void setPreco_veiculo(String preco_veiculo) {
		this.preco_veiculo = preco_veiculo;
	}
	public String getCombst_veiculo() {
		return combst_veiculo;
	}
	public void setCombst_veiculo(String combst_veiculo) {
		this.combst_veiculo = combst_veiculo;
	}
	public String getDescr_veic() {
		return descr_veic;
	}
	public void setDescr_veic(String descr_veic) {
		this.descr_veic = descr_veic;
	}
	@Override
	public String toString() {
		return "AnuncioBean [id_anunc_veic=" + id_anunc_veic + ", anunc_fabricante=" + anunc_fabricante
				+ ", anunc_modelo=" + anunc_modelo + ", anunc_anoVeic=" + anunc_anoVeic + ", anunc_veiculo="
				+ anunc_veiculo + ", ipva_StatusVeic=" + ipva_StatusVeic + ", licenca_StatusVeic=" + licenca_StatusVeic
				+ ", foto_Veic=" + foto_Veic + ", km_Veic=" + km_Veic + ", preco_veiculo=" + preco_veiculo
				+ ", combst_veiculo=" + combst_veiculo + ", descr_veic=" + descr_veic + "]";
	}

}
