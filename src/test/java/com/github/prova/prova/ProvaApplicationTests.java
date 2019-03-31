package com.github.prova.prova;

import com.github.prova.entity.Cliente;
import com.github.prova.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvaApplicationTests {

	private Cliente cliente;
	@MockBean
	private ClienteRepository clienteRepository;


	@Before
	public void init(){
		cliente = new Cliente();
		cliente.setSexo("M");
		cliente.setStatus(true);
		cliente.setCpf("12345678901");
		cliente.setDataNascimento(LocalDate.of(1989,3, 3));
		cliente.setEmail("atila.sistemas@gmail.com");
		cliente.setEstadoCivel("S");
		cliente.setNome("Nome de Teste");
		Mockito.when(clienteRepository.findByCpfEquals("12345678901")).thenReturn(Arrays.asList(cliente));
	}

	@Test
	public void pesquisar() {
		List<Cliente> clientes = clienteRepository.findByCpfEquals("12345678901");
		Assertions.assertThat(clientes.size()).isEqualTo(1);
		Assertions.assertThat(clientes.stream().findFirst().get().getNome()).isEqualTo("Nome de Teste");
	}

}
