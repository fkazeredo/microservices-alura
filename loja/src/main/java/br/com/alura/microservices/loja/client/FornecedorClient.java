package br.com.alura.microservices.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.microservices.loja.controller.dto.InfoFornecedorDTO;
import br.com.alura.microservices.loja.controller.dto.InfoPedidoDTO;
import br.com.alura.microservices.loja.controller.dto.ItemDaCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(value = "/pedido", method = RequestMethod.POST)
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
	
}
