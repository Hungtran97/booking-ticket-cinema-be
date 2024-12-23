package org.cybersoft.bookingticketcinemabe.query.impl;

import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import org.cybersoft.bookingticketcinemabe.query.BaseQuery;
import org.cybersoft.bookingticketcinemabe.query.QueryPredicate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class BaseQueryImpl<R, Q extends BaseQueryImpl<R, Q>> implements BaseQuery<R, Q> {
    protected final Collection<QueryPredicate<R>> predicates;

    public BaseQueryImpl() {
        this.predicates = new ArrayList<>();
    }

    protected abstract Q self();

    @Override
    public <V> Q equal(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V> Q equal(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute1)
                .get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V> Q equal(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                               SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute1)
                .get(attribute2)
                .get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V> Q equal(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                   SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4), value));
        return self();
    }

    @Override
    public <J, V> Q equal(SingularAttribute<J, V> attribute, V value, ListJoin<R, J> root) {
        predicates.add((criteria, cb, preRoot) -> cb.equal(root.get(attribute), value));
        return self();
    }

    @Override
    public <V> Q notEqual(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V> Q notEqual(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute1)
                .get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V> Q notEqual(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                  SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute1)
                .get(attribute2)
                .get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V> Q notEqual(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                      SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4), value));
        return self();
    }

    @Override
    public <J, V> Q notEqual(SingularAttribute<J, V> attribute, V value, ListJoin<R, J> root) {
        predicates.add((criteria, cb, preRoot) -> cb.notEqual(root.get(attribute), value));
        return self();
    }

    @Override
    public Q isTrue(SingularAttribute<R, Boolean> attribute) {
        predicates.add(((criteria, cb, root) -> cb.isTrue(root.get(attribute))));
        return self();
    }

    @Override
    public <P> Q isTrue(SingularAttribute<R, P> attribute1, SingularAttribute<P, Boolean> attribute2) {
        predicates.add(((criteria, cb, root) -> cb.isTrue(root.get(attribute1)
                .get(attribute2))));
        return self();
    }

    @Override
    public <P1, P2> Q isTrue(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                             SingularAttribute<P2, Boolean> attribute3) {
        predicates.add(((criteria, cb, root) -> cb.isTrue(root.get(attribute1)
                .get(attribute2)
                .get(attribute3))));
        return self();
    }

    @Override
    public <P1, P2, P3> Q isTrue(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                 SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, Boolean> attribute4) {
        predicates.add(((criteria, cb, root) -> cb.isTrue(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4))));
        return self();
    }

    @Override
    public <J> Q isTrue(SingularAttribute<J, Boolean> attribute, ListJoin<R, J> root) {
        predicates.add(((criteria, cb, preRoot) -> cb.isTrue(root.get(attribute))));
        return self();
    }

    @Override
    public Q isFalse(SingularAttribute<R, Boolean> attribute) {
        predicates.add(((criteria, cb, root) -> cb.isFalse(root.get(attribute))));
        return self();
    }

    @Override
    public <P> Q isFalse(SingularAttribute<R, P> attribute1, SingularAttribute<P, Boolean> attribute2) {
        predicates.add(((criteria, cb, root) -> cb.isFalse(root.get(attribute1)
                .get(attribute2))));
        return self();
    }

    @Override
    public <P1, P2> Q isFalse(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                              SingularAttribute<P2, Boolean> attribute3) {
        predicates.add(((criteria, cb, root) -> cb.isFalse(root.get(attribute1)
                .get(attribute2)
                .get(attribute3))));
        return self();
    }

    @Override
    public <P1, P2, P3> Q isFalse(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                  SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, Boolean> attribute4) {
        predicates.add(((criteria, cb, root) -> cb.isFalse(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4))));
        return self();
    }

    @Override
    public <J> Q isFalse(SingularAttribute<J, Boolean> attribute, ListJoin<R, J> root) {
        predicates.add(((criteria, cb, preRoot) -> cb.isFalse(root.get(attribute))));
        return self();
    }

    @Override
    public <V> Q isNull(SingularAttribute<R, V> attribute) {
        predicates.add(((criteria, cb, root) -> cb.isNull(root.get(attribute))));
        return self();
    }

    @Override
    public <P, V> Q isNull(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2) {
        predicates.add(((criteria, cb, root) -> cb.isNull(root.get(attribute1)
                .get(attribute2))));
        return self();
    }

    @Override
    public <P1, P2, V> Q isNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                SingularAttribute<P2, V> attribute3) {
        predicates.add(((criteria, cb, root) -> cb.isNull(root.get(attribute1)
                .get(attribute2)
                .get(attribute3))));
        return self();
    }

    @Override
    public <P1, P2, P3, V> Q isNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                    SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4) {
        predicates.add(((criteria, cb, root) -> cb.isNull(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4))));
        return self();
    }

    @Override
    public <J, V> Q isNull(SingularAttribute<J, V> attribute, ListJoin<R, J> root) {
        predicates.add(((criteria, cb, preRoot) -> cb.isNull(root.get(attribute))));
        return self();
    }

    @Override
    public <V> Q isNotNull(SingularAttribute<R, V> attribute) {
        predicates.add(((criteria, cb, root) -> cb.isNotNull(root.get(attribute))));
        return self();
    }

    @Override
    public <P, V> Q isNotNull(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2) {
        predicates.add(((criteria, cb, root) -> cb.isNotNull(root.get(attribute1)
                .get(attribute2))));
        return self();
    }

    @Override
    public <P1, P2, V> Q isNotNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                   SingularAttribute<P2, V> attribute3) {
        predicates.add(((criteria, cb, root) -> cb.isNotNull(root.get(attribute1)
                .get(attribute2)
                .get(attribute3))));
        return self();
    }

    @Override
    public <P1, P2, P3, V> Q isNotNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                       SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4) {
        predicates.add(((criteria, cb, root) -> cb.isNotNull(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4))));
        return self();
    }

    @Override
    public <J, V> Q isNotNull(SingularAttribute<J, V> attribute, ListJoin<R, J> root) {
        predicates.add(((criteria, cb, preRoot) -> cb.isNotNull(root.get(attribute))));
        return self();
    }

    @Override
    public <V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, P> attribute1,
                                                              SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute1)
                .get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, P1> attribute1,
                                                                   SingularAttribute<P1, P2> attribute2,
                                                                   SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute1)
                .get(attribute2)
                .get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, P1> attribute1,
                                                                       SingularAttribute<P1, P2> attribute2,
                                                                       SingularAttribute<P2, P3> attribute3,
                                                                       SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4), value));
        return self();
    }

    @Override
    public <J, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<J, V> attribute, V value, ListJoin<R, J> root) {
        predicates.add((criteria, cb, preRoot) -> cb.greaterThan(root.get(attribute), value));
        return self();
    }

    @Override
    public <V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, P> attribute1,
                                                           SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute1)
                .get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, P1> attribute1,
                                                                SingularAttribute<P1, P2> attribute2,
                                                                SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute1)
                .get(attribute2)
                .get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, P1> attribute1,
                                                                    SingularAttribute<P1, P2> attribute2,
                                                                    SingularAttribute<P2, P3> attribute3,
                                                                    SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4), value));
        return self();
    }

    @Override
    public <J, V extends Comparable<? super V>> Q lessThan(SingularAttribute<J, V> attribute, V value, ListJoin<R, J> root) {
        predicates.add((criteria, cb, preRoot) -> cb.lessThan(root.get(attribute), value));
        return self();
    }

    @Override
    public Q like(SingularAttribute<R, String> attribute, String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute), "%" + value + "%"));
        return self();
    }

    @Override
    public <P> Q like(SingularAttribute<R, P> attribute1, SingularAttribute<P, String> attribute2, String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute1)
                .get(attribute2), "%" + value + "%"));
        return self();
    }

    @Override
    public <P1, P2> Q like(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                           SingularAttribute<P2, String> attribute3, String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute1)
                .get(attribute2)
                .get(attribute3), "%" + value + "%"));
        return self();
    }

    @Override
    public <P1, P2, P3> Q like(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                               SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, String> attribute4,
                               String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .get(attribute4), "%" + value + "%"));
        return self();
    }

    @Override
    public <J> Q like(SingularAttribute<J, String> attribute, String value, ListJoin<R, J> root) {
        predicates.add((criteria, cb, preRoot) -> cb.like(root.get(attribute), "%" + value + "%"));
        return self();
    }

    @SafeVarargs
    @Override
    public final Q and(QueryPart<R>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root)))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P> Q and(SingularAttribute<R, P> attribute, QueryPart<P>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute))))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2> Q and(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, QueryPart<P2>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1)
                            .get(attribute2))))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2, P3> Q and(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3, QueryPart<P3>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1)
                            .get(attribute2)
                            .get(attribute3))))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <J> Q and(ListJoin<R, J> root, QueryPart<J>... partQueries) {
        predicates.add((criteria, cb, preRoot) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root)))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final Q or(QueryPart<R>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root)))
                    .toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P> Q or(SingularAttribute<R, P> attribute, QueryPart<P>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute))))
                    .toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2> Q or(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, QueryPart<P2>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1)
                            .get(attribute2))))
                    .toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2, P3> Q or(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                   SingularAttribute<P2, P3> attribute3, QueryPart<P3>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1)
                            .get(attribute2)
                            .get(attribute3))))
                    .toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @Override
    public <J> Q or(ListJoin<R, J> root, QueryPart<J>... partQueries) {
        predicates.add((criteria, cb, preRoot) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root)))
                    .toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }


    @Override
    public <V> Q in(SingularAttribute<R, V> attribute, Collection<V> values) {
        predicates.add((criteria, cb, root) -> root.get(attribute)
                .in(values));
        return self();
    }

    @Override
    public <P, V> Q in(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2, Collection<V> values) {
        predicates.add((criteria, cb, root) -> root.get(attribute1)
                .get(attribute2)
                .in(values));
        return self();
    }

    @Override
    public <P1, P2, V> Q in(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                            SingularAttribute<P2, V> attribute3, Collection<V> values) {
        predicates.add((criteria, cb, root) -> root.get(attribute1)
                .get(attribute2)
                .get(attribute3)
                .in(values));
        return self();
    }

    @Override
    public <J, V> Q in(SingularAttribute<J, V> attribute, Collection<V> values, ListJoin<R, J> root) {
        predicates.add((criteria, cb, preRoot) -> root.get(attribute)
                .in(values));
        return self();
    }

    @Override
    public Q between(String attribute, LocalDateTime from, LocalDateTime to) {
        predicates.add((criteria, cb, root) -> cb.between(root.get(attribute), from, to));
        return self();
    }

    protected <T> Predicate[] buildPredicates(CommonAbstractCriteria criteria, Collection<QueryPredicate<T>> predicates,
                                              CriteriaBuilder cb, Path<T> path) {
        return predicates
                .stream()
                .map(t -> t.apply(criteria, cb, path))
                .toArray(Predicate[]::new);
    }
}
