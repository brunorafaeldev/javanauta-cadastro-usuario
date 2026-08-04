package com.javanauta.usuario.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor //com todos os argumentos/paramêtros
@NoArgsConstructor // sem argumentos/paramêtros
@Entity //Identifica que é uma tabela, assim como o @Collum para informar que é uma coluna
@Builder
@Table(name = "usuario") //Indica o nome da tabela
public class Usuario implements UserDetails { // Para que o usuário seja validado como usuário de login e senha

    @Id //Informar um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id",referencedColumnName = "id") //Relacionamento em cascata, excluir usuário, exlcui o endereço
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

}

// Obs. no MongoDB ao invés do @Entity usamos o @Document para informar que aquela classe é uma coleção