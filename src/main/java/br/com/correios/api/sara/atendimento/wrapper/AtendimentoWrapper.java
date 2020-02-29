package br.com.correios.api.sara.atendimento.wrapper;

import java.util.Date;
import java.util.List;

import br.com.correios.api.sara.atendimento.model.Atendimento;

public class AtendimentoWrapper {
	public static void calculaIsInativo(List<Atendimento>	 objetoAtendimentoList) {
//		objetoAtendimentoList.forEach(objetoAtendimento -> {
//			Date dataIni = objetoAtendimento.getDataInicioExecucao();
//			Date dataFim = objetoAtendimento.getDataFimExecucao();
//			Date dataAtual = new Date();
//			if(dataFim == null) {
//				objetoAtendimento.setInativo(false);
//			}else { 
//				long diffMilliSeconds = dataAtual.getTime() - dataFim.getTime();
//				long diffMinutos = diffMilliSeconds/1000/60;
//				if(diffMinutos  > 10) {
//					objetoAtendimento.setInativo(false);	
//				}else {
//					objetoAtendimento.setInativo(true);
//				}
//			}
//		});
	}
}
