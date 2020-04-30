package com.july.bpm.db.model.query;

import com.july.bpm.query.Direction;
import com.july.bpm.query.FieldSort;

import java.io.Serializable;

/**
 * 字段排序。
 *
 * <pre>
 * </pre>
 */
public class DefaultFieldSort implements FieldSort, Serializable {

    private Direction direction;
    private String field;

    public DefaultFieldSort(String field) {
        this(field, Direction.ASC);
    }

    public DefaultFieldSort(String field, Direction direction) {
        this.direction = direction;
        this.field = field;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public String getField() {
        return field;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field + (direction == null ? "" : " " + direction.name());
    }

}
