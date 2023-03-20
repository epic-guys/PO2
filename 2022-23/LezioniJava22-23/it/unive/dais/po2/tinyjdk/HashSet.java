package it.unive.dais.po2.tinyjdk;

public class HashSet<T> implements Set<T> {
    private List<T> l = new ArrayList<>();

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public void add(T x) {
        if (!contains(x))
            l.add(x);
    }

    @Override
    public void remove(T x) {
        for (int i = 0; i < l.size(); ++i) {
            T o = l.get(i);
            if (o.hashCode() == x.hashCode())
                l.removeAt(i);
        }
    }

    @Override
    public boolean contains(T x) {
        for (int i = 0; i < l.size(); ++i) {
            T o = l.get(i);
            if (o.hashCode() == x.hashCode())
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return l.iterator();
    }

    @Override
    public boolean contains(Predicate<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
