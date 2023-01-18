package org.ahmeteminsaglik.searchnode.controllers;

import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.concretes.DataInfo;

import java.util.List;

/**
 * DPI : Development Programing Interface
 */
public class SearchNodeAPI<T> implements SearchNodeService<T> {
    SearchNodeService<T> searchNodeService = new SearchNode<>();

    @Override
    public Result addAll(List<T> list) {
        return searchNodeService.addAll(list);
    }

    @Override
    public Result add(T t) {
        return searchNodeService.add(t);
    }

    @Override
    public DataResult<DataInfo<T>> search(String text) {
        return searchNodeService.search(text);
    }

    @Override
    public DataResult<List<T>> getAll() {
        return searchNodeService.getAll();
    }

    @Override
    public DataResult<List<T>> getAllReverse() {
        return searchNodeService.getAllReverse();
    }

    @Override
    public DataResult<List<T>> getAllStartWith(String text) {
        return searchNodeService.getAllStartWith(text);
    }

    @Override
    public long getTotalItemNumber() {
        return searchNodeService.getTotalItemNumber();
    }
}
