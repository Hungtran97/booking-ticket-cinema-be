package org.cybersoft.bookingticketcinemabe.query;

import jakarta.persistence.metamodel.SingularAttribute;
import org.cybersoft.bookingticketcinemabe.query.utils.Order;

import java.util.List;
import java.util.Optional;

public interface SelectQuery<R, Q extends SelectQuery<R, Q>> extends BaseQuery<R, Q> {
    List<R> findAll();

    <P> List<P> findAll(SingularAttribute<R, P> attribute);

    <P1, P2> List<P2> findAll(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    R getOne();

    <P> P getOne(SingularAttribute<R, P> attribute);

    <P1, P2> P2 getOne(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    Optional<R> findOne();

    <P> Optional<P> findOne(SingularAttribute<R, P> attribute);

    <P1, P2> Optional<P2> findOne(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    long count();

    <P> long count(SingularAttribute<R, P> attribute);

    <P1, P2> long count(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    <P> SelectQuery<R, Q> order(SingularAttribute<R, P> attribute);

    <P> SelectQuery<R, Q> order(SingularAttribute<R, P> attribute, Order order);

    <P1, P2> SelectQuery<R, Q> order(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    <P1, P2> SelectQuery<R, Q> order(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, Order order);

    <P1, P2, P3> SelectQuery<R, Q> order(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3);

    <P1, P2, P3> SelectQuery<R, Q> order(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3, Order order);

    <P> SelectQuery<R, Q> fetch(SingularAttribute<R, P> attribute);

    <P1, P2> SelectQuery<R, Q> fetch(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    <P1, P2, P3> SelectQuery<R, Q> fetch(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3);

}