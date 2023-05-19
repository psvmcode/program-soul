package 集合源码;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2022/12/31 14:31
 */
public class HashSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
