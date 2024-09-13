package com.project.caixa.Controller;

import com.project.caixa.Mapper.ProdutoMapper;
import com.project.caixa.Model.Produto;
import com.project.caixa.Model.ProdutoRequest;
import com.project.caixa.Model.ProdutoResponse;
import com.project.caixa.Service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoMapper mapper;

    @Operation(summary = "Salvar", description = "Método que salva o produto", tags = "Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Bad request"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse salvar(@RequestBody ProdutoRequest request){
        Produto produto = mapper.toProduto(request);
        return produtoService.salvarProduto(produto);
    }

    @Operation(summary = "Listar", description = "Método que lista todos os produtos", tags = "Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Bad request"),
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoResponse> listaProdutos(){
        return produtoService.listaProdutos();
    }
}
