/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DaniloPC
 */

@Entity
@Table(name="ClienteServico")
public class ClienteServico implements Serializable{
	
        private static final long serialVersionUID = 1L;
        
        @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long usuario_servico_id;
        
        @Column(name = "usuario_id")
        private Long usuario_id;
        
        @Column(name = "servico_id")
        private Long servico_id;
        
        @Temporal(TemporalType.DATE)
        private Date di;
        
        
        @Temporal(TemporalType.DATE)
        private Date df;

        public Long getId() {
		return usuario_servico_id;
	}
	public void setId(Long usuario_servico_id) {
		this.usuario_servico_id = usuario_servico_id;
	}
        
        public Long getUsuarioId() {
		return usuario_id;
	}
	public void setUsuarioId(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
        
        public Long getServicoId() {
		return servico_id;
	}
	public void setServicoId(Long servico_id) {
		this.servico_id = servico_id;
	}
        
        
        public Date getDi() {
            return di;
        }
        
        public void setDi(Date di) {
            this.di = di;
        }
        
        public Date getDf() {
            return df;
        }
        
        public void setDf(Date df) {
            this.df = df;
        }
}
