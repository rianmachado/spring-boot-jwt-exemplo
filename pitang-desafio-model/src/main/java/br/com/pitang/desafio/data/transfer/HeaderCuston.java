package br.com.pitang.desafio.data.transfer;

/**
 * @author rianmachado@gmail.com
 * 
 */
public class HeaderCuston {

	private String tipo;
	private String mensagem;
	private int code;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
