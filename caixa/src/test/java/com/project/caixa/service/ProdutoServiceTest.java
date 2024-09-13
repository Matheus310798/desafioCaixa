package com.project.caixa.service;

import com.project.caixa.Model.Produto;
import com.project.caixa.Service.ProdutoService;
import com.project.caixa.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @InjectMocks
    ProdutoService service;

    @Mock
    ProdutoRepository repository;

    Produto produtoMock;
    List<Produto> produtoListMock;

    @BeforeEach
    public void setUp() {
        produtoMock = new Produto(1L, "Produto", 10.10);
        produtoListMock = Arrays.asList(
                new Produto(1L, "PRODUTO1", 10.10),
                new Produto(2L, "PRODUTO2", 20.20)
        );
    }

    @Test
    void deveSalvarProdutoComSucesso() {
        when(repository.save(produtoMock)).thenReturn(produtoMock);

        service.salvarProduto(produtoMock);

        verify(repository).save(produtoMock);
        verifyNoMoreInteractions(repository);

    }

    @Test
    void deveRetornarListaDeProdutos(){
        when(repository.findAll()).thenReturn(produtoListMock);

        service.listaProdutos();

        verify(repository).findAll();
        verifyNoMoreInteractions(repository);

    }

}
