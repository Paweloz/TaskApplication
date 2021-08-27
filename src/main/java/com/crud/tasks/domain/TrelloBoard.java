package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TrelloBoard {
    private String id;
    private String name;
    private List<TrelloList> lists;

    public TrelloBoard(String name, List<TrelloList> lists) {
        this.name = name;
        this.lists = lists;
    }
}