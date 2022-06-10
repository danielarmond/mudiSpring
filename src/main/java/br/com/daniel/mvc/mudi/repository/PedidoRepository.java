package br.com.daniel.mvc.mudi.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.daniel.mvc.mudi.model.Pedido;
import br.com.daniel.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	@Cacheable("pedidos")
	Iterable<Pedido> findByStatus(StatusPedido status, PageRequest paginacao);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	Iterable<Pedido> findAllByUsuario(@Param("username")String username);



}
