package org.serratec.musicmanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name="album_capa")
public class Capa {

	@Id()
	@Column(name="alb_cd_id")
	private Long id;
	@Column(name="alc_tx_media_type")
	private String mimetype;
	@Lob
	@Column(name="alc_bl_capa")
	private byte[] data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
}
