package com.step.orm.rdb.operator.builder.fragments;

import com.step.orm.rdb.operator.builder.FragmentBlock;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@NoArgsConstructor(staticName = "of")
public class BlockSqlFragments implements SqlFragments {

    private Map<FragmentBlock, LinkedList<SqlFragments>> blocks = new TreeMap<>(FragmentBlock::compareTo);

    @Override
    public boolean isEmpty() {
        return blocks.isEmpty();
    }

    @Override
    public List<String> getSql() {
        return blocks
                .values()
                .stream()
                .flatMap(Collection::stream)
                .map(SqlFragments::getSql)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getParameters() {
        return blocks.values()
                .stream()
                .flatMap(Collection::stream)
                .map(SqlFragments::getParameters)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


    public BlockSqlFragments addBlock(FragmentBlock block, String sql) {
        getBlock(block).add(SqlFragments.single(sql));
        return this;
    }

    public BlockSqlFragments addBlockFirst(FragmentBlock block, String sql) {
        getBlock(block).addFirst(SqlFragments.single(sql));
        return this;
    }

    public BlockSqlFragments addBlock(FragmentBlock block, SqlFragments fragments) {
        getBlock(block).add(fragments);
        return this;
    }

    public BlockSqlFragments addBlockFirst(FragmentBlock block, SqlFragments fragments) {
        getBlock(block).addFirst(fragments);
        return this;
    }


    public LinkedList<SqlFragments> getBlock(FragmentBlock block) {
        return blocks.computeIfAbsent(block, __ -> new LinkedList<>());
    }

    @Override
    public String toString() {

        return toRequest().toString();
    }
}
