package com.project.caixa.Service;

import com.project.caixa.Enum.MessagesEnum;
import com.project.caixa.Exception.DefaultException;
import com.project.caixa.Mapper.ProdutoMapper;
import com.project.caixa.Model.Produto;
import com.project.caixa.Model.ProdutoResponse;
import com.project.caixa.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.caixa.Mapper.ProdutoMapper.toProdutosResponseList;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper mapper;


    public ProdutoResponse salvarProduto(Produto produto){
        try {
            produtoRepository.save(produto);
            return mapper.produtoToProdutoResponse(produto);
        } catch (Exception e) {
            throw new DefaultException(MessagesEnum.PRODUTO_SAVE_EXCEPTION.getDescricao(), e);
        }
    }

    public List<ProdutoResponse> listaProdutos(){
        try {
            List<Produto> produtosList =  produtoRepository.findAll();
            return toProdutosResponseList(produtosList);
        } catch (Exception e) {
            throw new DefaultException(MessagesEnum.PRODUTO_LIST_EXCEPTION.getDescricao(), e);
        }
    }
}
