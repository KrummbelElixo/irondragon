package br.unitins.tp1.irondragon.model.usuario;

import br.unitins.tp1.irondragon.model.DefaultEntity;
import br.unitins.tp1.irondragon.model.Endereco;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
public class Usuario extends DefaultEntity {
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String senha;
    @Column(unique = true, nullable = false)
    private String cpf;
    private Perfil perfil;

    private LocalDateTime dataCriacao;

    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    List<Endereco> enderecos;
}
