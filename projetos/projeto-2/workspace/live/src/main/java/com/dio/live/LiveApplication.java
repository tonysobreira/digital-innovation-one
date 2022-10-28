package com.dio.live;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.BancoHorasId;
import com.dio.live.model.Calendario;
import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.Empresa;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Localidade;
import com.dio.live.model.Movimentacao;
import com.dio.live.model.MovimentacaoId;
import com.dio.live.model.NivelAcesso;
import com.dio.live.model.Ocorrencia;
import com.dio.live.model.TipoData;
import com.dio.live.model.Usuario;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.repository.CalendarioRepository;
import com.dio.live.repository.CategoriaUsuarioRepository;
import com.dio.live.repository.EmpresaRepository;
import com.dio.live.repository.JornadaTrabalhoRepository;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.repository.MovimentacaoRepository;
import com.dio.live.repository.NivelAcessoRepository;
import com.dio.live.repository.OcorrenciaRepository;
import com.dio.live.repository.TipoDataRepository;
import com.dio.live.repository.UsuarioRepository;

@SpringBootApplication
public class LiveApplication implements CommandLineRunner {
	
	@Autowired
	private JornadaTrabalhoRepository jornadaTrabalhoRepository;
	
	@Autowired
	private NivelAcessoRepository nivelAcessoRepository;
	
	@Autowired
	private TipoDataRepository tipoDataRepository;
	
	@Autowired
	private CalendarioRepository calendarioRepository;
	
	@Autowired
	private CategoriaUsuarioRepository categoriaUsuarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private BancoHorasRepository bancoHorasRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JornadaTrabalho jt1 = JornadaTrabalho.builder()
				.descricao("JornadaTrabalho1")
				.build();
		JornadaTrabalho jt2 = JornadaTrabalho.builder()
				.descricao("JornadaTrabalho2")
				.build();
		jornadaTrabalhoRepository.saveAll(Arrays.asList(jt1, jt2));
		
		NivelAcesso na1 = NivelAcesso.builder()
				.descricao("NivelAcesso1")
				.build();
		NivelAcesso na2 = NivelAcesso.builder()
				.descricao("NivelAcesso2")
				.build();
		nivelAcessoRepository.saveAll(Arrays.asList(na1, na2));
		
		TipoData td1 = TipoData.builder()
				.descricao("TipoData1")
				.build();
		TipoData td2 = TipoData.builder()
				.descricao("TipoData2")
				.build();
		tipoDataRepository.saveAll(Arrays.asList(td1, td2));
		
		Calendario c1 = Calendario.builder()
				.tipoData(td1)
				.descricao("Calendario1")
				.dataEspecial(LocalDateTime.now())
				.build();
		Calendario c2 = Calendario.builder()
				.tipoData(td2)
				.descricao("Calendario2")
				.dataEspecial(LocalDateTime.now())
				.build();
		calendarioRepository.saveAll(Arrays.asList(c1, c2));
		
		CategoriaUsuario cu1 = CategoriaUsuario.builder()
				.descricao("CategoriaUsuario1")
				.build();
		CategoriaUsuario cu2 = CategoriaUsuario.builder()
				.descricao("CategoriaUsuario2")
				.build();
		categoriaUsuarioRepository.saveAll(Arrays.asList(cu1, cu2));
		
		Empresa e1 = Empresa.builder()
				.descricao("Empresa1")
				.cnpj("cnpj1")
				.endereco("endereco1")
				.bairro("bairro1")
				.cidade("cidade1")
				.estado("estado1")
				.telefone("telefone1")
				.build();
		Empresa e2 = Empresa.builder()
				.descricao("Empresa2")
				.cnpj("cnpj2")
				.endereco("endereco2")
				.bairro("bairro2")
				.cidade("cidade2")
				.estado("estado2")
				.telefone("telefone2")
				.build();
		empresaRepository.saveAll(Arrays.asList(e1, e2));
		
		Localidade l1 = Localidade.builder()
				.nivelAcesso(na1)
				.descricao("Localidade1")
				.build();
		Localidade l2 = Localidade.builder()
				.nivelAcesso(na2)
				.descricao("Localidade2")
				.build();
		localidadeRepository.saveAll(Arrays.asList(l1, l2));
		
		Ocorrencia o1 = Ocorrencia.builder()
				.nome("Nome1")
				.descricao("Descricao1")
				.build();
		Ocorrencia o2 = Ocorrencia.builder()
				.nome("Nome2")
				.descricao("Descricao2")
				.build();
		ocorrenciaRepository.saveAll(Arrays.asList(o1, o2));
		
		Usuario u1 = Usuario.builder()
			.categoriaUsuario(cu1)
			.nome("Nome1")
			.empresa(e1)
			.nivelAcesso(na1)
			.jornadaTrabalho(jt1)
			.tolerancia(new BigDecimal(1))
			.inicioJornada(LocalDateTime.now())
			.finalJornada(LocalDateTime.now())
			.build();
		Usuario u2 = Usuario.builder()
				.categoriaUsuario(cu2)
				.nome("Nome2")
				.empresa(e2)
				.nivelAcesso(na2)
				.jornadaTrabalho(jt2)
				.tolerancia(new BigDecimal(2))
				.inicioJornada(LocalDateTime.now())
				.finalJornada(LocalDateTime.now())
				.build();
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
		Movimentacao m1 = Movimentacao.builder()
				.id(new MovimentacaoId(u1.getId(), u1.getId()))
				.dataEntrada(LocalDateTime.now())
				.dataSaida(LocalDateTime.now())
				.periodo(new BigDecimal(1))
				.ocorrencia(o1)
				.calendario(c1)
				.build();

		Movimentacao m2 = Movimentacao.builder()
				.id(new MovimentacaoId(u2.getId(), u2.getId()))
				.dataEntrada(LocalDateTime.now())
				.dataSaida(LocalDateTime.now())
				.periodo(new BigDecimal(2))
				.ocorrencia(o2)
				.calendario(c2)
				.build();

		movimentacaoRepository.saveAll(Arrays.asList(m1, m2));
		
		BancoHoras bh1 = BancoHoras.builder()
				.id(new BancoHorasId(u1.getId(), u1.getId(), u1.getId()))
				.dataTrabalhada(LocalDateTime.now())
				.quantidadeHoras(new BigDecimal(1))
				.saldoHoras(new BigDecimal(1))
				.build();
		BancoHoras bh2 = BancoHoras.builder()
				.id(new BancoHorasId(u2.getId(), u2.getId(), u2.getId()))
				.dataTrabalhada(LocalDateTime.now())
				.quantidadeHoras(new BigDecimal(2))
				.saldoHoras(new BigDecimal(2))
				.build();
		bancoHorasRepository.saveAll(Arrays.asList(bh1, bh2));
	}

}
