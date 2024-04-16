package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.DataInfo;
import org.aes.searchnode.entities.concretes.NodeDataService;

import java.util.List;

/**
 * DPI : Development Programing Interface
 */
public class SearchNodeDPI<T> implements SearchNodeService<T> {
    SearchNodeService<T> searchNodeService = new SearchNode<>();

    @Override
    public Result addAll(List<T> list) {
        return searchNodeService.addAll(list);
    }

    @Override
    public Result update(T t, String oldExp, String newExp) {
        return searchNodeService.update(t, oldExp, newExp);
    }

    @Override
    public Result update(T t, String oldExp, List<String> expList) {
        return searchNodeService.update(t, oldExp, expList);
    }

    @Override
    public Result update(T t, List<String> expList) {
        return searchNodeService.update(t,expList);
    }

    @Override
    public Result add(T t) {
        return searchNodeService.add(t);
    }

    @Override
    public Result add(T t, String explanation) {
        return searchNodeService.add(t, explanation);
    }

    @Override
    public Result add(T t, List<String> expList) {
        return searchNodeService.add(t, expList);
    }

    @Override
    public DataResult<NodeDataService<T>> search(String text) {
        return searchNodeService.search(text);
    }

    @Override
    public DataResult<NodeDataService<T>> searchExplanationOf(String text) {
        return searchNodeService.searchExplanationOf(text);
    }

    @Override
    public DataResult<List<DataInfo<T>>> getAll() {
        return searchNodeService.getAll();
    }

    @Override
    public DataResult<List<DataInfo<T>>> getAllReverse() {
        return searchNodeService.getAllReverse();
    }

    @Override
    public DataResult<List<DataInfo<T>>> getAllStartWith(String text) {
        return searchNodeService.getAllStartWith(text);
    }

    @Override
    public int getTotalItemNumber() {
        return searchNodeService.getTotalItemNumber();
    }

    @Override
    public Result resetPriorityChar(char c) {
        return searchNodeService.resetPriorityChar(c);
    }

    @Override
    public Result resetAllPriorityChars() {
        return searchNodeService.resetAllPriorityChars();
    }

    @Override
    public Result updatePriorityChar(List<Character> cList, char nextToThisChar) {
        return searchNodeService.updatePriorityChar(cList, nextToThisChar);
    }

    @Override
    public Result updatePriorityChar(char c, char nextToThisChar) {
        return searchNodeService.updatePriorityChar(c, nextToThisChar);
    }
}
