package net.egork.collections;

/**
 * @author Egor Kulikov (kulikov@devexperts.com)
 */
public class Pair<U, V> {
	public static class Comparator<U extends Comparable<U>, V extends Comparable<V>> implements java.util.Comparator<Pair<U, V>> {
		public int compare(Pair<U, V> o1, Pair<U, V> o2) {
			int result = o1.first.compareTo(o2.first);
			if (result != 0)
				return result;
			return o1.second.compareTo(o2.second);
		}
	}

	public final U first;
	public final V second;

	public static<U, V> Pair<U, V> makePair(U first, V second) {
		return new Pair<U, V>(first, second);
	}

	private Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Pair pair = (Pair) o;

		return !(first != null ? !first.equals(pair.first) : pair.first != null) && !(second != null ? !second.equals(pair.second) : pair.second != null);

	}

	@Override
	public int hashCode() {
		int result = first != null ? first.hashCode() : 0;
		result = 31 * result + (second != null ? second.hashCode() : 0);
		return result;
	}

	public Pair<V, U> swap() {
		return makePair(second, first);
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
}