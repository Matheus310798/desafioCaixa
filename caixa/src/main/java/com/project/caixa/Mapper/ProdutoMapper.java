package com.project.caixa.Mapper;

import com.project.caixa.Model.Produto;
import com.project.caixa.Model.ProdutoRequest;
import com.project.caixa.Model.ProdutoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoMapper {

    public Produto toProduto(ProdutoRequest request){
        Produto produto = new Produto();
        produto.setNome(request.nome());
        produto.setPreco(request.preco());

        return produto;
    }
    public static ProdutoResponse produtoToProdutoResponse(Produto produto){
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getPreco());
    }

    public static List<ProdutoResponse> toProdutosResponseList(List<Produto> produtos){
        List<ProdutoResponse> responses = new ArrayList<>();
        for (Produto produto: produtos) {
            responses.add(produtoToProdutoResponse(produto));
        }
        return responses;
    }
}
