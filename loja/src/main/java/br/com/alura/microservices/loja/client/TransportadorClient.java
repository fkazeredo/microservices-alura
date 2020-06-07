package br.com.alura.microservices.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.microservices.loja.controller.dto.InfoEntregaDTO;
import br.com.alura.microservices.loja.controller.dto.VoucherDTO;

@FeignClient("transportador")
public interface TransportadorClient {

	@RequestMapping(path = "/entrega", method = RequestMethod.POST)
	VoucherDTO reservaEntrega(InfoEntregaDTO entregaDto);

}
