package com.project.caixa.Enum;

import lombok.Getter;

@Getter
public enum MessagesEnum {
    PRODUTO_SAVE_EXCEPTION("Erro inesperado ao salvar o produto"),
    PRODUTO_LIST_EXCEPTION("Erro inesperado ao listar todos os produtos");

    private String descricao;

    MessagesEnum(String descricao){this.descricao = descricao;}
}
