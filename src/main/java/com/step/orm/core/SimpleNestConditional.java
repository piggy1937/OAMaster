package com.step.orm.core;

import com.step.orm.core.param.Term;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class SimpleNestConditional<T extends TermTypeConditionalSupport>
        implements NestConditional<T> {
    private Term term;
    private T target;
    private Accepter<NestConditional<T>, Object> accepter = this::and;

    public SimpleNestConditional(T target, Term term) {
        this.term = term;
        this.target = target;
    }

    @Override
    public NestConditional<T> accept(Term term) {
        this.term.addTerm(term);
        return this;
    }

    @Override
    public T end() {
        return target;
    }


    @Override
    public NestConditional<T> and() {
        accepter = this::and;
        return this;
    }

    @Override
    public NestConditional<T> or() {
        accepter = this::or;
        return this;
    }

    @Override
    public Accepter<NestConditional<T>, Object> getAccepter() {
        return accepter;
    }

    @Override
    public NestConditional<NestConditional<T>> nest() {
        return new SimpleNestConditional<>(this, this.term.nest());
    }

    @Override
    public NestConditional<NestConditional<T>> nest(String column, Object value) {
        return new SimpleNestConditional<>(this, this.term.nest(column, value));
    }

    @Override
    public NestConditional<NestConditional<T>> orNest() {
        return new SimpleNestConditional<>(this, this.term.orNest());
    }

    @Override
    public NestConditional<NestConditional<T>> orNest(String column, Object value) {
        return new SimpleNestConditional<>(this, this.term.orNest(column, value));
    }

    @Override
    public NestConditional<T> and(String column, String termType, Object value) {
        term.and(column, termType, value);
        return this;
    }

    @Override
    public NestConditional<T> or(String column, String termType, Object value) {
        term.or(column, termType, value);
        return this;
    }
}