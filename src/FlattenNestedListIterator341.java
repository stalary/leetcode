/**
 * @(#)FlattenNestedListIterator341.java, 2019-03-27.
 *
 * Copyright 2019 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * FlattenNestedListIterator341
 *
 * @author lirongqian
 * @since 2019/03/27
 */
public class FlattenNestedListIterator341 implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<>();

    private Integer index = 0;

    public FlattenNestedListIterator341(List<NestedInteger> nestedList) {
        list.addAll(flat(nestedList));
    }

    private List<Integer> flat(List<NestedInteger> nestedIntegerList) {
        List<Integer> ret = new ArrayList<>();
        nestedIntegerList.forEach(n -> {
            if (n.isInteger()) {
                ret.add(n.getInteger());
            } else {
                ret.addAll(flat(n.getList()));
            }
        });
        return ret;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

}