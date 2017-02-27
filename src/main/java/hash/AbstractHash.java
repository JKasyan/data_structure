package hash;

/**
 * Created by kasyan on 2/25/17.
 */
abstract class AbstractHash implements Hash {

    protected int maxSize;

    AbstractHash() {
        maxSize = 10;
    }

    protected int hashFunction(long el) {
        return (int) el % maxSize;
    }
}
