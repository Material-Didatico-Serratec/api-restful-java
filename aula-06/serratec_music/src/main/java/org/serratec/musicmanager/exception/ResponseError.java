package org.serratec.musicmanager.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseError {
	private LocalDateTime horaErro;
	private List<MensagemErro> erros;
	
	public LocalDateTime getHoraErro() {
		return horaErro;
	}
	public void setHoraErro(LocalDateTime horaErro) {
		this.horaErro = horaErro;
	}
	public List<MensagemErro> getErros() {
		return erros;
	}
	public void setErros(List<MensagemErro> erros) {
		this.erros = erros;
	}
	
	

}
