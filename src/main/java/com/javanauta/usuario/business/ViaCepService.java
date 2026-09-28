package com.javanauta.usuario.business;

import com.javanauta.usuario.infrastructure.clients.ViaCepClient;
import com.javanauta.usuario.infrastructure.clients.ViaCepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

        private final ViaCepClient viaCepClient;

        public ViaCepDTO buscaDadosEndereco( String cep) {

                return viaCepClient.buscaDadosEndereco(processarCep(cep));
        }

        private String processarCep (String cep) {
            String cepFormatado = cep.replace(" ", "").replace("-", "");

            if(!cepFormatado.matches("\\d+") || !Objects.equals(cepFormatado.length(), 8)) {

                throw new IllegalArgumentException("O cep contém caracteres inválidos, por favor verificar!");

            }

            return cepFormatado;

        }


}
