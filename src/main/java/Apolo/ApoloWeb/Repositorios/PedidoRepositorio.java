package Apolo.ApoloWeb.Repositorios;

import Apolo.ApoloWeb.Entidades.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido,String>{
    @Query("SELECT c FROM Pedido c WHERE c.id = :id")
    public List<Pedido> buscarPedidoPorId(@Param("id") String id);
}
