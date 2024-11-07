package br.unitins.tp1.irondragon.repository;

import br.unitins.tp1.irondragon.model.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    public Pedido findByUsername(String username) {
        return find("SELECT p FROM Pedido p WHERE p.usuario.username = ?1", username).firstResult();
    }
}
