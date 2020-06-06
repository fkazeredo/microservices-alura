package br.com.alura.microservices.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.loja.client.FornecedorClient;
import br.com.alura.microservices.loja.controller.dto.CompraDTO;
import br.com.alura.microservices.loja.controller.dto.InfoFornecedorDTO;
import br.com.alura.microservices.loja.controller.dto.InfoPedidoDTO;
import br.com.alura.microservices.loja.model.Compra;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		
		String estado = compra.getEndereco().getEstado();
		
		LOG.info("Buscando informações de fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("Realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
	
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(info.getEndereco());
		
		return compraSalva;
		
	}

}
